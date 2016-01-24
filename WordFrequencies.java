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

public class WordFrequencies {

	public static Map<String, Integer> computeWordFrequencies(List<String> tokenList) {

		Map<String, Integer> wordFrequencyMap = new LinkedHashMap<String, Integer>();

		for (int i = 0; i < tokenList.size(); i++) {
			String token = tokenList.get(i);
			int count=0;
			if (wordFrequencyMap.containsKey(token)) {
				count = wordFrequencyMap.get(token) + 1;
			} else {
				count = 1;
			}
			wordFrequencyMap.put(token, count);
		}
		return wordFrequencyMap;
	}

	// Source:
	// http://stackoverflow.com/questions/109383/sort-a-mapkey-value-by-values-java
	public static <String, Integer extends Comparable<? super Integer>> Map<String, Integer> sortByValue(
			Map<String, Integer> map) {
		
		List<Map.Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(map.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		Map<String, Integer> result = new LinkedHashMap<String, Integer>();
		
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
			if(entry.getValue() >=184) {
				System.out.println("Token: " + entry.getKey() + "\tCount: " + entry.getValue());
			}
		}
		System.out.println("\nCount Of Tokens:" + sum);
	}

	public static void main(String[] args) {
		File TextFile = new File("pg100.txt");
		Utilities utilities = new Utilities();
		try {
			long startTime = System.currentTimeMillis();
			Map<String, Integer> list = sortByValue(computeWordFrequencies(utilities.tokenizeFile(TextFile)));
			long endTime = System.currentTimeMillis();
			printMap(list);
			System.out.println("\nThat took " + (endTime - startTime) + " milliseconds for size: " + list.size());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
