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
public class ThreeSumVerson2 {
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();

            if (nums.length < 3) {
                return new ArrayList<>();
            }

            Arrays.sort(nums);

            if (nums[0] > 0) {
                return new ArrayList<>();
            }

            for (int i = 0; i < nums.length - 1; i++) {

                //同样的元素跳过，从第二个元素开始，防止 如 0 0 0 0 的情况
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[left] + nums[i] + nums[right];

                    if (sum == 0) {
                        List<Integer> triple = new ArrayList<>(3);
                        triple.add(nums[left]);
                        triple.add(nums[i]);
                        triple.add(nums[right]);
                        result.add(triple);

                        //由于这里的元素是可以重用的，所以我们需要找出包含 nums[i]的所有的解 所以不需要提前退出。

                        //这里需要去重。因为如果nums[left] == nums[left + 1] 那么肯定会产生
                        // {nums[i],nums[left],the other} 和{nums[i],nums[left+1],the other} 相同的解
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;

                    } else if (sum > 0) {
                        right--;
                    } else {
                        left++;
                    }

                }

            }
            return result;
        }

    }
}
