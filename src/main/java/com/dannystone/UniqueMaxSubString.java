package com.dannystone;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:最长不重复子串。
 *
 * 将字符串 S 以字节切分成String.length个单字符子串 strings。
 *
 * 假设存在最大长度的唯一子串，以某字符A开头
 * 那么可遍历 strings 得到所有的可能性。
 *  不重复可以使用Set做去重。
 *
 * @author: daniel
 * @creed: keep it simple and stupid !
 * @Time: 2020/6/4 2:48 PM
 */
public class UniqueMaxSubString {
    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }

        char[] chars = s.toCharArray();
        String[] strings = toStringArray(chars);

        int maxLength = 0;
        Set<String> beforChars = new HashSet<>();
        for (int i = 0; i < strings.length; i++) {
            int tmpMaxLength = 0;
            beforChars.clear();
            for (int j = i; j < strings.length; j++) {
                if (!beforChars.contains(strings[j])) {
                    tmpMaxLength++;
                    beforChars.add(strings[j]);
                } else {
                    break;
                }
            }
            if (maxLength < tmpMaxLength) {
                maxLength = tmpMaxLength;
            }
        }
        return maxLength;
    }

    private static String[] toStringArray(char[] chars) {
        String[] strings = new String[chars.length];
        for (int i = 0; i < chars.length; i++) {
            strings[i] = String.format("%c", chars[i]);
        }
        return strings;
    }
}
