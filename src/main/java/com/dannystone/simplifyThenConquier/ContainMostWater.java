package com.dannystone.simplifyThenConquier;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: daniel
 * @creed: keep it simple and stupid !
 * @Time: 2020/3/28 1:32 PM
 */
public class ContainMostWater {
    /**
     * Sample code
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxArea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }

    /**
     * My code
     *
     * @param height
     * @return
     */
    public int myMaxArea(int[] height) {
        int low = 0, high = height.length - 1;
        int maxArea = 0;
        while (low < high) {
            int left = height[low];
            int right = height[high];

            int maxAreaThieRound = 0;
            if (left <= right) {
                maxAreaThieRound = left * (high - low);
                low++;
            } else {
                maxAreaThieRound = right * (high - low);
                high--;
            }
            if (maxAreaThieRound > maxArea) {
                maxArea = maxAreaThieRound;
            }
        }
        return maxArea;
    }
}
