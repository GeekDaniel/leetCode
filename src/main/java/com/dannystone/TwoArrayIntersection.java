package com.dannystone;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: daniel
 * @creed: keep it simple and stupid !
 * @Time: 2019/11/9 1:38 AM
 */
public class TwoArrayIntersection {

    //最简单双重遍历
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> matchIndexMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (matchIndexMap.values().contains(j)) {
                    //nums2不可重用退出
                    continue;
                }

                if (nums1[i] == nums2[j]) {
                    matchIndexMap.put(i, j);
                    //nums1不可重用
                    break;
                }


            }
        }

        int[] result = new int[matchIndexMap.keySet().size()];
        Iterator<Integer> iterator = matchIndexMap.keySet().iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Integer index = iterator.next();
            result[i] = nums1[index];
            i++;
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 3, 44, 44};
        int[] nums2 = new int[]{2, 44, 44};
        int[] intersect = intersect(nums1, nums2);
        System.out.println(JSONObject.toJSONString(intersect));


    }
}
