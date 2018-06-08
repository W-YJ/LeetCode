package SolutionsWithJava;

import java.util.HashMap;
import java.util.Map;

/*
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/description/
 * Runtime Beats 75.50
 * */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp) && map.get(temp) != i) {
                return new int[]{i, map.get(temp)};
            }
        }
        return null;
    }
}
