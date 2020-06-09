package com.dannystone;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: daniel
 * @creed: keep it simple and stupid !
 * @Time: 2020/3/29 1:57 PM
 */
public class MaxSubArray2 {
    public int maxSubArray(int[] nums) {
        int max = nums[0], continuousMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            continuousMax = Math.max(continuousMax + nums[i], nums[i]);
            max = Math.max(max, continuousMax);
        }
        return max;
    }

}

