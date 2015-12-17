import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Collections {

	public Collections() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// List<Integer> arrayList = new ArrayList<Integer>();
		// List<Integer> linkedList = new LinkedList<Integer>();
		//
		// doTimings("ArrayList", arrayList);
		// doTimings("LinkedList", linkedList);

		// Maps hold key value pairs, here key is an integer and value is a
		// string
		// HAshMaps DO NOT maintain any order, that is, they are not sorted
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();
		TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();

		// Creates a lookup table with key value pairs and can identify a value
		// using the associated key
		testmap(treeMap);
	}

	public static void testmap(Map<Integer, String> map) {
		map.put(1, "One");
		map.put(3, "Three");
		map.put(4, "Four");
		map.put(5, "Five");
		map.put(2, "Two");

		// String text = map.get(4);

		// for (Map.Entry<Integer, String> entry : map.entrySet()) {
		// int key = entry.getKey();
		// String value = entry.getValue();
		//
		// System.out.println(key + ": " + value);
		// }
		
		for(Integer key: map.keySet()){
			String value = map.get(key);
			System.out.println(key + ": " + value);
		}
	}

	@SuppressWarnings("unused")
	private static void doTimings(String type, List<Integer> list) {

		for (int i = 0; i <= 1E5; i++) {
			list.add(i);
		}

		long start = System.currentTimeMillis();

		// Remove items from the list
		// list.remove(1E5);

		// Add items at the end of list
		/*
		 * for (int i = 0; i <= 1E5; i++) { list.add(i); }
		 */

		// Add items to the beginning of the list
		/*
		 * for (int i = 0; i <= 1E5; i++) { list.add(0, i); }
		 */

		long end = System.currentTimeMillis();

		System.out.println("Time taken: " + (end - start) + "ms by " + type);
	}

}
