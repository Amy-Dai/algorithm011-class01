package org.example.geektime.test.middle.q1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q1 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                int sum1 = target - nums[i];
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        int sum2 = sum1 - nums[j];
                        int low = j + 1, high = nums.length - 1;
                        while (low < high) {
                            if (nums[low] + nums[high] == sum2) {
                                result.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                                while (low < high && nums[low] == nums[low + 1]) {
                                    low++;
                                }
                                while (low < high && nums[high] == nums[high - 1]) {
                                    high--;
                                }
                                low++;
                                high--;
                            } else if (nums[low] + nums[high] > sum2) {
                                high--;
                            } else {
                                low++;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
