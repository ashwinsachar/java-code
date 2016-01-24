package assignment1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Anagrams {

	private static String stringSorter(String token) {
		char[] charArr = token.toCharArray();
		Arrays.sort(charArr);
		String sorted = new String(charArr);
		return sorted;
	}

	private static Map<String, List<String>> anagramDictionary() throws IOException {

		String dictionary = "words.txt";
		String line;

		FileReader filereader = new FileReader(dictionary);
		BufferedReader bufferedreader = new BufferedReader(filereader);

		Map<String, List<String>> anagramMap = new HashMap<String, List<String>>();

		try {
			while ((line = bufferedreader.readLine()) != null) {

				String angm = line.toLowerCase().replaceAll("[^a-zA-Z]", "");
				String sortedWord = stringSorter(angm);

				if (!anagramMap.containsKey(sortedWord)) {
					List<String> anagramList1 = new ArrayList<String>();
					anagramMap.put(sortedWord, anagramList1);
				}
				List<String> anagramList = anagramMap.get(sortedWord);
				if (!anagramList.contains(angm)) {
					anagramList.add(angm);
				}
			}
			bufferedreader.close();
			List<Map.Entry<String, List<String>>> anagramMaplist = new LinkedList<>(anagramMap.entrySet());
			for (Map.Entry<String, List<String>> entry : anagramMaplist) {
				if (entry.getValue().size() == 1) {
					anagramMap.remove(entry.getKey());
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return anagramMap;

	}

	private static void createAnagramFile() throws IOException {

		File angmFile = new File("anagram.ser");

		FileOutputStream filesOS = new FileOutputStream(angmFile);
		ObjectOutputStream objOS = new ObjectOutputStream(filesOS);

		objOS.writeObject(anagramDictionary());
		objOS.close();

	}

	public static Map<String, List<String>> detectAnagrams(List<String> list)
			throws IOException, ClassNotFoundException {
		FileInputStream fileIS = new FileInputStream("anagram.ser");
		ObjectInputStream objIS = new ObjectInputStream(fileIS);

		Map<String, List<String>> angmDict = (Map<String, List<String>>) objIS.readObject();
		Map<String, List<String>> tokenList = new HashMap<String, List<String>>();

		for (String token : list) {
			String sortedToken = stringSorter(token);

			if (angmDict.containsKey(sortedToken)) {
				List<String> matchedAngms = angmDict.get(sortedToken);
				List<String> newList = new ArrayList<String>();
				for (String addValue : matchedAngms) {
					if (addValue.hashCode() != token.hashCode()) {
						newList.add(addValue);
					}
				}
				tokenList.put(token, newList);
			}
		}
		return tokenList;
	}

	public static void print(Map<String, List<String>> anagrams) {
		Map<String, List<String>> sortedMap = new TreeMap<String, List<String>>(anagrams);
		for (Entry<String, List<String>> entry : sortedMap.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		File TextFile = new File("pg100.txt");
		Utilities utilities = new Utilities();

		List<String> list = utilities.tokenizeFile(TextFile);

		long startTime = System.currentTimeMillis();

		// createAnagramFile();

		Map<String, List<String>> dict = detectAnagrams(list);

		long endTime = System.currentTimeMillis();

		print(dict);

		System.out.println("Size of file: " + list.size());

		System.out.println("That took " + (endTime - startTime) + " milliseconds");

	}
}