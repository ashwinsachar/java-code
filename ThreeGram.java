package assignment1;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ThreeGram {

	public static Map<String, Integer> computeThreeGramFrequencies(List<String> tokens) {

		Map<String, Integer> threeGrams = new HashMap<String, Integer>();

		String s1, s2, s3;
		int i = 0;
		int j = 1;
		int k = 2;

		while (k < tokens.size()) {

			s1 = tokens.get(i);
			s2 = tokens.get(j);
			s3 = tokens.get(k);

			String result = s1 + " " + s2 + " " + s3;
			int count;

			if (threeGrams.containsKey(result)) {
				count = threeGrams.get(result) + 1;
			} else {
				count = 1;
			}
			threeGrams.put(result, count);
			i++;
			j++;
			k++;
		}
	
		return threeGrams;
	}

	public static <String, Integer extends Comparable<? super Integer>> Map<String, Integer> sortByValue(
			Map<String, Integer> map) {
		
		List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		Map<String, Integer> result = new LinkedHashMap<>();
		
		for (Map.Entry<String, Integer> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}
	
	public static void printMap(Map<String, Integer> map) {
		int sum = 0;
		for (Entry<String, Integer> entry : map.entrySet()) {
		    sum += entry.getValue();
		}
		for (Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("Token: " + entry.getKey() + "\tCount: " + entry.getValue());
		}
		System.out.println("\nCount Of Tokens: " + sum);
	}
	
	public static void main(String[] args) {
		File TextFile = new File("pg10.txt");
		Utilities utilities = new Utilities();
		try {
			long startTime = System.currentTimeMillis();
			Map<String, Integer> list = sortByValue(computeThreeGramFrequencies(utilities.tokenizeFile(TextFile)));
			long endTime = System.currentTimeMillis();
			printMap(list);
			System.out.println("\nThat took " + (endTime - startTime) + " milliseconds for size: " + list.size());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
