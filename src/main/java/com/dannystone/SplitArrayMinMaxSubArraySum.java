package com.dannystone;

import com.sun.tools.corba.se.idl.constExpr.ShiftLeft;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: daniel
 * @creed: keep it simple and stupid !
 * @Time: 2020/4/2 10:51 PM
 */
public class SplitArrayMinMaxSubArraySum {
    public int splitArrayGreedy(int[] nums, int m) {
        //get left right
        long right = 0, left = 0;
        for (int num : nums) {
            right += num;
            if (left < num) {
                left = Math.max(left, num);
            }
        }

        long ans = right;
        while (left <= right) {

            //假设存在二分查找
            long mid = (left + right) / 2;

            //重算需要多少count
            long sum = 0;
            int count = 1;
            for (int num : nums) {
                if (sum + num <= mid) {
                    sum = sum + num;
                } else {
                    sum = num;
                    count++;
                }
            }

            //如果count 过小，说明mid太大。导致越界从新分得的子数组的数量少，缩小mid，缩小right

            if (count <= m) {
                right = mid - 1;
                ans = Math.min(ans, mid);

            } else {
                left = mid + 1;
            }

        }
        return (int) ans;

    }

    public static int splitArrayDynamicProgramming(int[] nums, int m) {
        //f[i][j] 表示i个元素的数组分成j个子数组 最小子数组最大和
        //如果第j个数组表示为nums[k+1] ....nums[i], 那么 f[i][j]=(f[k][j-1],nums[k+1]+ .... +nums[i])
        int length = nums.length;
        long[][] minMaxSubArray = new long[length + 1][length + 1];
        for (int i = 0; i < length + 1; i++) {
            for (int j = 0; j < length + 1; j++) {
                minMaxSubArray[i][j] = Long.MAX_VALUE;
            }
        }

        long[] subSum = new long[length + 1];
        for (int i = 0; i < length; i++) {
            subSum[i + 1] = subSum[i] + nums[i];
        }
        minMaxSubArray[0][0] = 0;
        for (int i = 1; i < length + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                for (int k = 0; k < i; k++) {
                    minMaxSubArray[i][j] = Math.min(minMaxSubArray[i][j], Math.max(minMaxSubArray[k][j - 1], subSum[i] - subSum[k]));
                }
            }
        }

        return (int) minMaxSubArray[length][m];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 2, 5, 10, 8};
        int m = 2;
        System.out.println(splitArrayDynamicProgramming(nums, m));
    }
}
