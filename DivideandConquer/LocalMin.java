package DivideandConquer;

public class LocalMin {

	public LocalMin() {}
	
	public static int localMin(int[] arr, int low, int hi) {
		
		// Conquer: Brute Force search over small array is O(constant)
		if(hi -low < 8) {
			for(int i=low;i<=hi; i++) {
				
				// case 1: considering middle elements
				if(i-1 >= 0 && i+1 < arr.length) {
					if(arr[i-1]>arr[i] && arr[i] < arr[i+1])
						return arr[i];
				}
				
				// case 2: considering leftmost
				if(i-1 < 0 && arr[i] < arr[i+1])
					return arr[i];
				
				// case 3: considering rightmost
				else if(i+1 >= arr.length && arr[i] < arr[i-1])
					return arr[i];
			}
			// no local min found
			return Integer.MAX_VALUE;
		}
		
		// Divide: boil arr down to size < 8, then BF search
		int mid = (hi+low)/2;
		int left = localMin(arr, 0, mid);
		int right = localMin(arr, mid+1, hi);
		
		// Handle return
		if(left != Integer.MAX_VALUE)
			return left;
		else if(right != Integer.MAX_VALUE)
			return right;
		return Integer.MAX_VALUE;
	}
	public static void main(String[] args) {
//		int[] arr = { 5, 4, 2, 3, 8 };
//		int[] arr = { 5, 4, 3, 2, 8 };
//		int[] arr = { 7, 6, 4, 3, 1 };
		int[] arr = {40, 20, 22, 24, 23, 25, 30, 32, 34, 36, 38, 42, 44, 46, 48, 50};
		for(Integer i : arr) {
			System.out.print(i +", ");
		}
		int result = localMin(arr, 0, arr.length-1);
		if(result == Integer.MAX_VALUE)
			System.out.println("\nNo local min :(");
		else
			System.out.println("\nLocal min: " + result);
	}

}
