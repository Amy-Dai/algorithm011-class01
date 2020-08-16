package org.example.leetcode.week01.q15;

import java.util.*;

public class Q15 {

    private static final int TARGET = 0;

    public List<List<Integer>> threeSum(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return new LinkedList<>();
        }
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0, left = 0; i < nums.length - 2; i++) {
            if (TARGET < nums[i]) {
                break;
            }
            if (0 < i && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1, k = nums.length - 1, tmpSum = 0; j < k;){
                tmpSum = nums[i] + nums[j] + nums[k];
                if (tmpSum == TARGET) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while ((j < k) && (nums[j] == nums[++j]));
                    while ((j < k) && (nums[k] == nums[--k]));
                } else if (tmpSum > TARGET) {
                    while ((j < k) && (nums[k] == nums[--k]));
                } else {
                    while ((j < k) && (nums[j] == nums[++j]));
                }
            }
        }
        return result;
    }
}
