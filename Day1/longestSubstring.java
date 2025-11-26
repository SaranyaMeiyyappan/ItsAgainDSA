package Day1;

import java.util.HashMap;

//Given a string s, find the length of the longest substring without duplicate characters.

public class longestSubstring {

	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println(mapSolution(s));
	}

	/**
	 * 
	 * left = 0, max = 0, startIndex = 0
	 * create a map, to store last occurence (index) of character (a,3)
	 * 
	 * for (right = 0, to s.length())
	 * 	if(map.containsKey(s.charAt(right) && map.get(s.charAt(right)>=left) //if char is outside of windown from left, then move left to next position
	 * 		left = map.get(right)+1
	 *  map.put(s[right], right);
	 *  if(right-left+1 > max)
	 *  	max = right-left+1;
	 *  	startIndex = left
	 *  return s.substring(startIndex, startIndex+max)
	 * 
	 */
	private static String mapSolution(String s) {
		int left = 0, max = 0, startIndex = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		for(int right = 0; right < s.length(); right++) {
			if(map.containsKey(s.charAt(right)) && map.get(s.charAt(right)) >= left) {
				left = map.get(s.charAt(right))+1; //left is a - 0, move to b - 1
			}
			map.put(s.charAt(right), right);

			if(right-left + 1 > max) {
				max = right-left+1;
				startIndex = left;
			}
		}
		return s.substring(startIndex, startIndex+max);
	}
}
