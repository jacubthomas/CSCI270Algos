package DynamicProgramming;

import java.util.ArrayList;

public class IndependentSet {
	static int[] memoize_me = { 1000000, 1000000, 1000000, 1000000, 1000000};
	public IndependentSet() {
	}
	
	public static int maxSet(ListNode ln, int i) {
		if(ln == null)
			return 0;
		
		else if(ln.next == null)
			return ln.val;
		
		else if(memoize_me[i] < 1000000)
			return memoize_me[i];
		
		memoize_me[i] = Math.max(maxSet(ln.next, i+1), maxSet(ln.next.next, i+2) + ln.val);
		
		return memoize_me[i];
	}
	public static void main(String[] args) {
		ListNode node5 = new ListNode(1);
		ListNode node4 = new ListNode(8, node5);
		ListNode node3 = new ListNode(8, node4);
		ListNode node2 = new ListNode(8, node3);
//		ListNode node2 = new ListNode(8);
		ListNode node1 = new ListNode(9, node2);
		
		int result = maxSet(node1, 0);
		System.out.println(result);
	}

}
