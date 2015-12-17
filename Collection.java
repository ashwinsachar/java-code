import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

class StringComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return o1.compareTo(o2);
	}

}

class Person {
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private int id;
	private String name;

	public Person(int id, String name) {
		this.id = id;
		this.name = name;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String toString() {
		return "{" + id + ": " + name + "} ";
	}
}

public class Collection {

	public Collection() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		//////// LISTS /////////

		// List<Integer> arrayList = new ArrayList<Integer>();
		// List<Integer> linkedList = new LinkedList<Integer>();

		// doTimings("ArrayList", arrayList);
		// doTimings("LinkedList", linkedList);

		/////// MAPS //////////

		// Maps hold key value pairs, here key is an integer and value is a
		// string
		// HashMaps DO NOT maintain any order, that is, they are not sorted

		// HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		// LinkedHashMap<Integer, String> linkedHashMap = new
		// LinkedHashMap<Integer, String>();
		// TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();

		// Creates a lookup table with key value pairs and can identify a value
		// using the associated key

		// testmap(linkedHashMap);

		/////// SETS //////////

		// Set<String> set1 = new TreeSet<String>();
		//
		// set1.add("Dogs");
		// set1.add("Horses");
		// set1.add("Bears");
		// set1.add("Anteaters");
		// set1.add("Cats");
		//
		// System.out.println("\nSet1:");
		//
		// for (String data : set1) {
		// System.out.println(data);
		// }
		//
		// if (set1.contains("Cats")) {
		// System.out.println("\nContains Cats");
		// }
		//
		// Set<String> set2 = new HashSet<String>();
		// set2.add("Eels");
		// set2.add("Goats");
		// set2.add("Sheep");
		// set2.add("Tuna");
		// set2.add("Cats");
		//
		// set1.addAll(set2);
		//
		// System.out.println("\nSet2:");
		//
		// for (String dataset2 : set2) {
		// System.out.println(dataset2);
		// }
		//
		// System.out.println("\nSet1 and Set2:");
		//
		// for (String dataset3 : set1) {
		// System.out.println(dataset3);
		// }

		///// Implementation Of HashCode and Equals methods. ///////

		// Person p1 = new Person(1, "Alice");
		// Person p2 = new Person(2, "Bob");
		// Person p3 = new Person(3, "Mike");
		// Person p4 = new Person(2, "Bob");
		//
		// Map<Person, Integer> map = new LinkedHashMap<Person, Integer>();
		//
		// map.put(p1, 1);
		// map.put(p2, 2);
		// map.put(p3, 3);
		// map.put(p4, 1);
		//
		// for (Person key : map.keySet()) {
		// System.out.println(key + ": " + map.get(key));
		// }
		//
		// Set<Person> set = new LinkedHashSet<Person>();
		//
		// set.add(p1);
		// set.add(p2);
		// set.add(p3);
		// set.add(p4);
		//
		// System.out.println(set);

		///// Implementation of Comparator sorting //////
		// List<String> animals = new ArrayList<String>();
		
		// animals.add("elephant");
		// animals.add("dog");
		// animals.add("cat");
		// animals.add("mouse");
		// animals.add("rabbit");

		////// Implementation of Comparator on arbitrary objects //////
		ArrayList<Person> per = new ArrayList<Person>();
		
		Person p1 = new Person(1, "Alice");
		Person p2 = new Person(2, "Bob");
		Person p3 = new Person(3, "Mike");
		Person p4 = new Person(4, "Alicia");
		
		per.add(p1);
		per.add(p2);
		per.add(p3);
		per.add(p4);
		
//		Collections.sort(per, new Comparator<Person>(){
//
//			@Override
//			public int compare(Person o1, Person o2) {
//				if (o1.getId() < o2.getId()){
//					return -1;
//				}
//				else if (o1.getId() > o2.getId()){
//					return 1;
//				}
//				return 0;
//			}
//			
//		});
		
		Collections.sort(per, new Comparator<Person>(){

			@Override
			public int compare(Person o1, Person o2) {
				return o1.getName().compareTo(o2.getName());
			}
			
		});

		for (Person people : per) {
			System.out.println(people);
		}

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

		for (Integer key : map.keySet()) {
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
