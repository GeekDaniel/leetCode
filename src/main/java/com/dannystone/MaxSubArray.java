package com.dannystone;

/**
 * Created with IntelliJ IDEA.
 * Description: 假设已经知道前i个元素的最大子队列和，那么前i+1个元素的最大子队列和改如何计算？
 * 此问题最纠结的点 maxSum(i+1)能否通过 maxSum(i)+nums[i+1] 来计算得到。直接相加是不行的。因为无法判断是否连续。
 * 所以需要新加入一个辅助变量。即在（0，i）元素中 在和位置i连续的最大子队列和continuousMax(i)
 * 因为是连续的所以 continuousMax(i+1)=max(continuousMax(i),(continuousMax(i)+nums[i+1]))
 *
 * @author: daniel
 * @creed: keep it simple and stupid !
 * @Time: 2020/3/29 1:57 PM
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {

        int maxSum = nums[0], continusMax = nums[0];
        int i = 1;
        while (i < nums.length) {
            maxSum = nums[i];
            continusMax = Math.max(nums[i], (continusMax + nums[i]));
            maxSum = Math.max(maxSum, continusMax);
            i++;
        }

        return maxSum;
    }

}

