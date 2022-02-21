package com.cisco.assignment.wordcount;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author atul Read the input text file and print count of word in descending
 *         order
 *
 */
public class WordCount {

	public static void main(String[] args) throws IOException {

		Map<String, Integer> map = new HashMap<>();

		File file = new File("./src/com/cisco/assignment/wordcount/input.txt");

		try {

			BufferedReader br = new BufferedReader(new FileReader(file));
			Pattern wordRegexPattern = Pattern.compile("([0-9]*[a-z]+([-'’](?=[a-z]))?((?<=[-'’])[a-z]+)*)");

			String line;

			while ((line = br.readLine()) != null) {
				Matcher wordMatcher = wordRegexPattern.matcher(line.toLowerCase());

				while (wordMatcher.find()) {
					String word = wordMatcher.group();
					map.put(word, map.getOrDefault(word, 0) + 1);

				}

			}

			br.close();

			final Map<String, Integer> sortedByCount = map.entrySet().stream()
					.sorted((Map.Entry.<String, Integer>comparingByValue().reversed())).collect(Collectors
							.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

			for (Entry<String, Integer> entry : sortedByCount.entrySet()) {

				System.out.println(entry.getValue() + " " + entry.getKey());

			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Input file is not found");
		}

	}

}
