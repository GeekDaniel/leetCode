package com.dannystone;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: daniel
 * @creed: keep it simple and stupid !
 * @Time: 2019/11/12 10:00 PM
 */
public class FindUniqueInPair {
    public static int singleNumber(int[] nums) {
        {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (!set.add(nums[i])) { // add成功返回true，如果set中已有相同数字，则add方法会返回false
                    set.remove(nums[i]); // 删除重复出现的数字
                }
            }
            return set.iterator().next();

        }
    }

}
