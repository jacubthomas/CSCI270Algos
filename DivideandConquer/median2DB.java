package DivideandConquer;

import java.util.HashMap;
import java.util.Map;

public class median2DB {

	// assume size of m1/m2 is power of two. logic is sound,
	// implementation for varying sizes is hairy....
	
	public static int findMedian(HashMapSorting m1, HashMapSorting m2) {
		int size = m1.size();
		return  findMedianHelp(m1, m2, 1, size, 1, size);
	}
	public static int findMedianHelp(HashMapSorting m1, HashMapSorting m2, 
											int l1, int h1, int l2, int h2) {
		if(l1  == h1) {
			int q1 = m1.median(l1);
			int q2 = m2.median(l2);
			return Math.min(q1, q2);
		}
		int q1 = (l1 + h1 - 1) / 2;
		int q2 = (l2 + h2 - 1) / 2;
		int med1 = m1.median(q1);
		int med2 = m2.median(q2);
		if(med1 < med2) {
			return findMedianHelp(m1,m2, q1+1, h1, l2, q2);
		} else {
			return findMedianHelp(m1,m2, l1, q1, q2+1, h2);
		}
	}

	public static void main(String[] args) {
		HashMap<Integer, Integer> m = new HashMap();
//		m.put(1, 10);
//		m.put(2, 30);
//		m.put(3, 20);
//		m.put(4, 5);
//		m.put(5, 40);
		m.put(1, 10);
		m.put(2, 4);
		m.put(3, 20);
		m.put(4, 5);
//		m.put(5, 40);
		HashMapSorting m1 = new HashMapSorting(m);
		m1.sort();
		HashMap<Integer, Integer> m_ = new HashMap();
//		m_.put(1, 1);
//		m_.put(2, 35);
//		m_.put(3, 71);
//		m_.put(4, 8);
//		m_.put(5, 4);
		m_.put(1, 1);
		m_.put(2, 35);
		m_.put(3, 71);
		m_.put(4, 8);
//		m_.put(5, 4);
		HashMapSorting m2 = new HashMapSorting(m_);
		m2.sort();
		System.out.print("Median of two DB is: " + findMedian(m1,m2));
	}

}
