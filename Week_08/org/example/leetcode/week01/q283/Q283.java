package org.example.leetcode.week01.q283;

public class Q283 {
    public void moveZeroes(int[] nums) {
        if(null == nums || 0 == nums.length){
            return;
        }
        for (int curId = 0, firstZeroId = 0; curId < nums.length && firstZeroId < nums.length; curId++) {
            if (nums[curId] != 0) {
                int tmp = nums[curId];
                nums[curId] = nums[firstZeroId];
                nums[firstZeroId++] = tmp;
            }
        }
    }
}
