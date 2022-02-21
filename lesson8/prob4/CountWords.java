package lesson8.prob4;

import java.util.List;;

public class CountWords {

	public int countWords(List<String> words, char c, char d, int len) {

		return 
				(int)words.stream()
				.filter(word -> lengthMatches(word, len))
				.filter(word -> containsC(word, c))
				.filter(word -> notContainD(word, d))
				.count();

	}

	public boolean lengthMatches(String word, int len) {

		return word.length() == len;
	}

	public boolean containsC(String word, char c) {

		return word.indexOf(c) != -1;
	}

	public boolean notContainD(String word, char d) {

		return word.indexOf(d) == -1;
	}

	public static void main(String[] args) {
		CountWords cw = new CountWords();

		System.out.println(String.format("words that contain c and do not contain d and with length 4  are : "
				 + cw.countWords(WordList.WORDS, 'c', 'd', 4)));

	}

}
