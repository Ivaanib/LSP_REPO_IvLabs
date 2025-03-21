package org.howard.edu.lsp.midterm.question4;

import java.util.ArrayList;
import java.util.List;

/**
 * Processes a sentence to find all longest words.
 */
public class WordProcessor {
	
	/**
	 * Ivan Ibhawoh
	 * @param args
	 */
    private String sentence;

    /**
     * Constructs a WordProcessor with the given sentence.
     * @param sentence the sentence to process
     */
    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }

    /**
     * Finds all words with the maximum length in the sentence.
     * @return a list of the longest words in order of appearance
     */
    public List<String> findLongestWords() {
        if (sentence == null || sentence.trim().isEmpty()) {
            return new ArrayList<>();
        }

        String[] words = sentence.trim().split("\\s+");
        List<String> longestWords = new ArrayList<>();
        int maxLength = 0;

        for (String word : words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
                longestWords.clear();
                longestWords.add(word);
            } else if (word.length() == maxLength) {
                longestWords.add(word);
            }
        }
        return longestWords;
    }
}