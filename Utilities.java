package assignment1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Utilities {
	List<String> list = new ArrayList<String>();

	List<String> tokenizeFile(File textFile) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(textFile));
		String token;
		String regex = "[^a-zA-Z0-9\\s]";
		Pattern pattern = Pattern.compile(regex);
		while ((token = reader.readLine()) != null) {
			if (token.trim().length() == 0){
				continue;
			}
			String cToken = token.toLowerCase().trim().replaceAll(pattern.pattern(), "");
			String[] tok = cToken.split("[\\s]+");
			for (String t : tok) {
				list.add(t);
			}
		}
		reader.close();
		return list;
	}

	static void print(List<String> list) {
		for (String l : list) {
			System.out.println(l);
		}
	}

	public static void main(String[] args) throws IOException {
		// File TextFile = new File("/Users/ashwinachar/Desktop/test.txt");
		File TextFile = new File("pg100.txt");
		Utilities utilities = new Utilities();
		try {
			long startTime = System.currentTimeMillis();
			List<String> list = utilities.tokenizeFile(TextFile);
			long endTime = System.currentTimeMillis();
			print(list);
			System.out.println("That took " + (endTime - startTime) + " milliseconds for size: " + list.size());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
