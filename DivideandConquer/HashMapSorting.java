package DivideandConquer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapSorting {
	  public HashMap<Integer, Integer> map;
	  LinkedHashMap<Integer, Integer> linkedMap;
	  ArrayList<Map.Entry<Integer, Integer>> arr;

		public void sort() {				
		for(Map.Entry<Integer, Integer> e: map.entrySet()) {
				arr.add(e);
			}
		
			Comparator<Map.Entry<Integer, Integer>> valueComparator = new Comparator<Map.Entry<Integer, Integer>>() {
		        
		        @Override
		        public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
		            Integer v1 = e1.getValue();
		            Integer v2 = e2.getValue();
		            return v1.compareTo(v2);
		        }
		};
		
			Collections.sort(arr, valueComparator);
		
			for(Map.Entry<Integer, Integer> e: arr) {
				linkedMap.put(e.getKey(), e.getValue());
				System.out.println("key: " + e.getKey() + ", value: " +  e.getValue());
			}
			System.out.println();
		}
	  public int median(int key) {
		  int count = 1;
		  for(Map.Entry<Integer, Integer> e: arr) {
			  if(count == key) {
				  return e.getValue();
			  }
			  count++;
		  }
		  return -1000000;
	  }
	  public int size() {
		  return linkedMap.size();
	  }
	  HashMapSorting(HashMap<Integer, Integer> map){
	    this.map = map;

//	    	map.put("a", 10);
//			map.put("b", 30);
//			map.put("c", 20);
//			map.put("d", 5);
//			map.put("e", 40);
//	    map.put(1, 10);
//		map.put(2, 30);
//		map.put(3, 20);
//		map.put(4, 5);
//		map.put(5, 40);

	    linkedMap = new LinkedHashMap<>();
	    arr = new ArrayList<>();
	  }

}
