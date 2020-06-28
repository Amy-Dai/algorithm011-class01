package org.example.leetcode.q1;

import java.util.HashMap;
import java.util.Map;

public class Q1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0, leftNum = -1; i < nums.length; i++){
            leftNum = target - nums[i];
            if (numMap.containsKey(leftNum)) {
                return new int[]{numMap.get(leftNum), i};
            } else {
                numMap.put(nums[i], i);
            }
        }
        return null;
    }
}
