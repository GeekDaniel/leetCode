package com.dannystone;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description: 确定一个子串的首字母，然后逐渐向右扩大。直到发现重复。那么这个时候可以确定以该首字母开头的子串最长可达多长。
 * 这样就可以将问题转化为，以不同首字母开头的子串最长有多长。
 *
 * @author: daniel
 * @creed: keep it simple and stupid !
 * @Time: 2020/3/28 7:13 PM
 */
public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i = 0, j = 0;
        Set<String> set = new HashSet<>();
        int maxLength = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j) + "")) {
                set.add(s.charAt(j) + "");
                j++;
                maxLength = Math.max(j - i, maxLength);
            } else {
                set.remove(s.charAt(i) + "");
                i++;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(" "));
    }
}
