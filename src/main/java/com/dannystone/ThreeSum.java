package com.dannystone;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: daniel
 * @creed: keep it simple and stupid !
 * @Time: 2019/11/13 11:13 PM
 */
public class ThreeSum {
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums.length < 3) {
                return new ArrayList<>();
            }

            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);

            if (nums[0] > 0) {
                return new ArrayList();
            }

            Set<String> indexUsed = new HashSet<>();
            int i = 1;
            while (i < nums.length - 1) {

                //此处会受限，不能移除重复数据，因为不像 i L R 这样遍历，会遍历所有的可能性，
                //i-1 i i+1 的起始条件会左右会成为相互约束的条件。
                int l = i - 1;
                int r = i + 1;
                while (r < nums.length && l >= 0) {
                    int sum = nums[i] + nums[l] + nums[r];
                    if (sum == 0) {
                        String key = nums[i] + "_" + nums[l] + "_" + nums[r];

                        if (!indexUsed.contains(key)) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[l]);
                            list.add(nums[r]);
                            result.add(list);
                            indexUsed.add(key);

                        }
                        r++;
                        l--;
                    } else if (sum < 0) {
                        r++;
                    } else {
                        l--;
                    }
                }
                i++;

            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{-1,0,1,2,-1,-4};
        solution.threeSum(nums);

    }
}
