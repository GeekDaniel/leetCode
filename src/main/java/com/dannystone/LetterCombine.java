package com.dannystone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description: 看起来是一个动态规划问题 满足最优子结的特点
 *
 * @author: daniel
 * @creed: keep it simple and stupid !
 * @Time: 2019/11/24 8:41 PM
 */
public class LetterCombine {

    private static final Map<Integer, char[]> digitCharsMap = new HashMap<>();

    static {
        digitCharsMap.put(2, new char[]{'a', 'b', 'c'});
        digitCharsMap.put(3, new char[]{'d', 'e', 'f'});
        digitCharsMap.put(4, new char[]{'g', 'h', 'i'});
        digitCharsMap.put(5, new char[]{'j', 'k', 'l'});
        digitCharsMap.put(6, new char[]{'m', 'n', 'o'});
        digitCharsMap.put(7, new char[]{'p', 'q', 'r', 's'});
        digitCharsMap.put(8, new char[]{'t', 'u', 'v'});
        digitCharsMap.put(9, new char[]{'w', 'x', 'y', 'z'});

    }

    //新添加一个数字即为将这个数字的可能字符追加到已有结果末尾
    List<String> appendANewLetter(char[] letters, List<String> results) {
        List<String> newResults = new ArrayList<>();
        for (char letter : letters) {
            for (String result : results) {
                newResults.add(result + letter);
            }
        }
        return newResults;
    }

    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        char[] digitChars = digits.toCharArray();

        if (digitChars.length == 0) {
            return results;
        }

        int digitValueAt0 = Integer.parseInt(digitChars[0] + "");
        char[] lettersAt0 = digitCharsMap.get(digitValueAt0);
        for (char letter : lettersAt0) {
            results.add(letter + "");
        }

        for (int i = 1; i < digitChars.length; i++) {
            int digitValue = Integer.parseInt(digitChars[i] + "");
            char[] letters = digitCharsMap.get(digitValue);
            results = appendANewLetter(letters, results);
        }
        return results;

    }


}
