package DivideandConquer;

public class maxSubArray {
	// Runtime: O(nlogn)
	public static int mM(int[] nums, int low, int mid, int high) {
		
		// traverse left from middle element, find max of these elements
		int sum = 0;
        int left_sum = Integer.MIN_VALUE;
        for(int i=mid; i>=0; i--) {
        	sum += nums[i];
        	if(sum > left_sum) left_sum = sum;
        }
        
        // traverse right from middle element, find max of these elements
        sum = 0;
        int right_sum = Integer.MIN_VALUE;
        for(int i=mid+1; i<= high; i++) {
        	sum += nums[i];
        	if(sum > right_sum) right_sum = sum;
        }
        
        // 3 cases: return left, right, or left + right
        return Math.max(left_sum+right_sum, Math.max(left_sum, right_sum));
	}
	
	 public static int mSA(int[] nums, int low, int high){
		 
		// Base Case: if problem size = 1
        if(low == high) return nums[low];
        
        // Divide
        int mid = (high+low)/2;
        int lsum = mSA(nums, low, mid);
        int rsum = mSA(nums, mid+1, high);
        int msum = mM(nums, low, mid, high);
        
        // Handle return
        return Math.max(Math.max(rsum, lsum), msum);
    }

	public static void main(String[] args) {
		int[] nums = { 5, 4, -1, 7, 8 };
//		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		int result = mSA(nums, 0, nums.length-1);
		System.out.println(result);
	}

}
