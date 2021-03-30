package DynamicProgramming;

public class Knapsack {

	static int[][] cache_money;
	static int[] q_types = { 1, 4, 5,  7, 9 };
	static int optcalls = 0;
	public Knapsack() {}
	
	
	public static int opt(int type, int x, int count) {
		
		// found a solution, return up call stack
		if(x==0)return 0;
		
		// prevents array-out-of-bounds exceptions
		else if(type < 0) return Integer.MAX_VALUE;
		
		// if solution has been previously computed, return it
		else if(cache_money[x][type] > -1) {
//			optcalls --;
			return cache_money[x][type];
		}
		
		// if the current question type yields more points than target
		else if(x < q_types[type]) {
			optcalls++;
			return opt(type-1, x, count);
		}
		
		// transitions
		optcalls++;optcalls++;
		count = Math.min(opt(type-1, x, count), opt(type, x - q_types[type], count+1) + 1);
		
		return count;
	}

	public static void main(String[] args) {
		int x = 100;
		cache_money = new int[x+1][q_types.length];
		
		for(int i=0; i<=x; i++) {
			for(int j=0; j<q_types.length; j++) {
				cache_money[i][j] = -1;
			}
		}
		
		// x number of subproblems, using n variables
		for(int j=0; j<q_types.length; j++) {
			for(int i=0; i<=x; i++) {
				cache_money[i][j] = opt(j, i, 0);
				System.out.println(cache_money[i][j]);
			}
		}
		System.out.print("optcalls: " + optcalls);
	}

}
