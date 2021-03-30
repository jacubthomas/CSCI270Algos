package DivideandConquer;

public class findMaxUnsorted {
	static int[] arr;
	public static double fMU(int lo, int hi) {
		if(hi - lo == 1)
			return (double)arr[lo]/arr[hi];
		
		int mid = (lo + hi)/2;
		double right = -1; 
		double left = fMU(lo, mid);
		if((mid+1) != hi) 
			right = fMU(mid+1, hi);
		else
			right = fMU(mid, hi);
		double merge = -1;
		
		
		// 1 4 16 2 35 47 3 8 89 6
		if(hi-lo > 1) {
			if(left > 1) {
				if(right > 1)
					merge =  (double)arr[lo]/arr[hi];
				else if(right < 1 && mid+1 != hi)
					merge = lo/(mid+1);
				else if(right < 1 && mid+1 == hi)
					merge = (double)arr[lo]/arr[mid];
			}
			else if( left < 1) {
				if(right > 1)
					merge =  (double)arr[lo+1]/arr[hi];
				else if(right < 1 && mid+1 != (lo+1))
					merge = (double)arr[lo+1]/arr[mid+1];
				else if(right < 1 && mid+1 == (lo+1))
					merge = (double)arr[lo]/arr[mid];
			}
		}
		return Math.max(left, Math.max(right, merge));
	}

	public static void main(String[] args) {
		arr = new int[10]; arr[0] = 100; arr[1] = 4;
		arr[2] = 16; arr[3] = 2; arr[4] = 35;
		arr[5] = 47; arr[6] = 3; arr[7] = 8;
		arr[8] = 89; arr[9] = 6;  
		double result = fMU(0, arr.length-1);
		System.out.println(result);
	}

}
