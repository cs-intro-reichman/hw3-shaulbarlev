/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {

	// System.out.println(preProcess("HEEE!!!!! ok."));

		// // Tests the isAnagram function.
		// System.out.println(isAnagram("silent","listen"));  // true
		// System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		// System.out.println(isAnagram("Madam Curie","Radium came")); // true
		// System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// // Tests the preProcess function.
		// System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		// System.out.println(removeIndex("telaviv", 0));
		// System.out.println("silent".length());
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	public static int charCounter(char c, String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (c == str.charAt(i)) {
				count++;
			}
		}

		return count;
	}

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
		str2 = preProcess(str2);

		if (str1.length() != str2.length()) return false;

		for (int i = 0; i < str2.length(); i++) {
			char c = str1.charAt(i);
			if (charCounter(c, str2) != charCounter(c, str1)) {
				return false;
			}
		}

		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		// Replace the following statement with your code
		str = str.toLowerCase();
		String out = "";
		String badChars = " _?!.,";

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (badChars.indexOf(c) == -1 ) {
				out = out + c;
			}
		}

		return out;
	}
	
	public static String removeIndex(String str, int index) {
		String out = "";
		int strLength = str.length();

		for (int i = 0; i < strLength; i++) {
			if (i != index) {
				out = out + str.charAt(i);
			}
		}

		return out;
	}
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		str = preProcess(str);

		String out = "";
		String workingStr = str;
		int origStrLength = str.length();

		for (int i = 0; i < origStrLength; i++) {
			int randomIndex = (int)(Math.random() * workingStr.length()); 
			char c = workingStr.charAt(randomIndex);
			out = out + c;

			workingStr = removeIndex(workingStr, randomIndex);
		}

		return out;
	}
}
