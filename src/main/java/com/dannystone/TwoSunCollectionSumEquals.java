package com.dannystone;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: daniel
 * @creed: keep it simple and stupid !
 * @Time: 2019/12/2 11:37 PM
 */
public class TwoSunCollectionSumEquals {
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        //early check
        if ((sum & 1) == 1) {
            return false;
        }

        int halfValue = sum / 2;

        //在集合中找一半的数，如果和等于halfValue 那就返回
        //状态迁移方程为 dp[i][j] : 在下标为[0，i]的集合区间内，能否找到和为j的元素，找到为true 找不到为false
        boolean[][] dp = new boolean[nums.length][halfValue + 1];

        for (int j = 0; j <= halfValue; j++) {
            if (nums[0] == j) {
                dp[0][j] = true;
                break;
            }
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= halfValue; j++) {
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                }else if (j > nums[i]) {
                    dp[i][j] = dp[i - 1][j - nums[i]];
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (dp[i][halfValue]) {
                return true;
            }
        }
        return false;

    }
    public static void main(String[] args){
        int[] nums = new int[]{23,13,11,7,6,5,5};
        TwoSunCollectionSumEquals twoSunCollectionSumEquals = new TwoSunCollectionSumEquals();
        System.out.println(twoSunCollectionSumEquals.canPartition(nums));;


    }
}
