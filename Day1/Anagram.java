package Day1;

import java.util.Arrays;
import java.util.*;
import java.util.Optional;
import java.util.stream.Collectors;

//Check if two strings are anagrams.

/**
 * 
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * 
 * Input: s = "rat", t = "car"
 * Output: false
 * 
 */

public class Anagram {

	public static void main(String[] args) {
		String s = "rat";
		String t = "car";
		System.out.println(hashMapSoultion(s,t));
		System.out.println(intArraySolution(s,t));
		System.out.println(hashMapStreams(s,t));
		System.out.println(intArrayStreams(s,t));
	}

	private static boolean intArrayStreams(String s, String t) {
		if (s == null || t == null || s.length() != t.length()) return false;

        // Create a map of character counts for s
        Map<Character, Long> mapS = s.chars()
                                    .mapToObj(c -> (char) c)
                                    .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        // Create a map of character counts for t
        Map<Character, Long> mapT = t.chars()
                                    .mapToObj(c -> (char) c)
                                    .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        // Compare maps
        return mapS.equals(mapT);
	}

	private static boolean hashMapStreams(String s, String t) {
		boolean isAnagram = Optional.ofNullable(s)
				.map(str -> str.chars()
						.mapToObj(c -> (char)c)
						.collect(Collectors.groupingBy(c -> c, Collectors.counting())))
				.map(maps -> { //good example of reusing an earlier intermediate result in a lambda
					Map<Character, Long> mapT = t.chars()
							.mapToObj(c -> (char)c)
							.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
					return maps.equals(mapT);
				}).orElse(false);
		return isAnagram;
	}

	/**
	 * 
	 * if s.length differs t.length, return false
	 * Create int[26] count array
	 * iterate s.toCharArray, increment int[sChar-'a']++
	 * iterate t.toCharArray, decrement int[tChar-'a']--
	 * 		if any value of int[tChar-'a'] < 0, then return false
	 * else return true
	 * 
	 * Time Complexity - O(n) - n length of string
	 * 
	 */
	private static boolean hashMapSoultion(String s, String t) {
		if(s.length()!=t.length()) return false;
		HashMap<Character, Integer> map = new HashMap<>();
		for(Character c:s.toCharArray()) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			} else {
				map.put(c, 1);
			}
		}
		for(Character c:t.toCharArray()) {
			if(map.containsKey(c)) {
				if(map.get(c)>0) {
					map.put(c, map.get(c)-1);
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * if s.length differs t.length, return false
	 * iterate s.toCharArray[] - add the char and frequency in map
	 * iterate t.toCharArray[] - check the char in map and decrease the frequency in map
	 * 		if any char not found in map, return false
	 * 		if any char frequency gone to negative, return false
	 * else return true
	 * 
	 * Complexity - O(n) - n length of string
	 * Space Complexity - O(1) max 26 keys
	 * 
	 */
	/**
	 * 
	 * Why char - 'a' works?
	 * 'a' is ASCII 97
	 * 'b' is 98
	 * 'c' is 99
	 * 'b' - 'a' = 98 - 97 = 1
	 * 
	 */
	private static boolean intArraySolution(String s, String t) {
		if(s.length()!=t.length()) return false;
		int[] charArray = new int[26];
		System.out.println(Arrays.toString(charArray));
		for(int i=0; i<s.length(); i++) {
			charArray[s.charAt(i)-'a']++;
		} 
		System.out.println(Arrays.toString(charArray));
		for(int i=0; i<t.length(); i++) {
			charArray[t.charAt(i)-'a']--;
			System.out.println(Arrays.toString(charArray));
			if(charArray[t.charAt(i)-'a']<0) {
				return false;
			}
		}
		return true;
	}

}
