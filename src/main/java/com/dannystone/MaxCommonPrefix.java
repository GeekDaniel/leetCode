package com.dannystone;

/**
 * Created with IntelliJ IDEA.
 * Description:最长公共前缀
 * 两两比较
 *
 * @author: daniel
 * @creed: keep it simple and stupid !
 * @Time: 2020/6/4 5:19 PM
 */
public class MaxCommonPrefix {

    public static String getMaxCommonPrefix(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        StringBuilder commonPrefix = new StringBuilder();
        for (int i = 0; i < Math.min(s1.toCharArray().length, s2.toCharArray().length); i++) {
            if (chars1[i] == chars2[i]) {
                commonPrefix.append(chars1[i]);
            } else {
                break;
            }

        }
        return commonPrefix.toString();

    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 ) {
            return "";
        }

        if(strs.length==1){
            return strs[0];
        }

        String first = strs[0];
        String second = strs[1];
        String longestCommonPrefix = getMaxCommonPrefix(first, second);

        for (int i = 2; i < strs.length; i++) {
            if(longestCommonPrefix.length()==0){
                return "";
            }
            longestCommonPrefix=getMaxCommonPrefix(longestCommonPrefix, strs[i]);
        }
        return longestCommonPrefix;

    }


}
