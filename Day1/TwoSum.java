package Day1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


 
//Problem: Given an array and a target, return indices of two numbers that add up to the target.

/**
 * 
 * Create a map
 * iterate array
 * find complement = target - current element from array
 * if complement exists, returns the indices
 * else store the complement in array
 * 
 * 
 * Space - O(n)
 * Time - O(n)
 * 
 * “I use a HashMap to store previously seen values in O(1) average time.
 * For each element, I check if the complement exists in the map, which is also O(1).
 * So the total time complexity is O(n) because I scan the array once.
 * Space complexity is O(n) for the map.”
 * 
 */

public class TwoSum {

	public static void main(String[] args) {
		int[] nums = {2,7,11,15}; int target = 9;
		System.out.println(Arrays.toString(twoSum(nums, target)));
	}

	private static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<nums.length; i++) {
			if(map.containsKey(target-nums[i])) {
				result[0] = map.get(target-nums[i]);
				result[1] = i;
				break;
			} else {
				map.put(nums[i], i);
			}
		}
		return result;
	}

}
