package com.dannystone;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: daniel
 * @creed: keep it simple and stupid !
 * @Time: 2020/3/30 7:50 PM
 */
public class ValidKuoHao {


    public boolean isValid(String s) {
        Map<String, String> pairs = new HashMap<>();
        pairs.put("{", "}");
        pairs.put("(", ")");
        pairs.put("[", "]");

        Stack<String> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (pairs.containsKey(aChar + "")) {
                stack.push(aChar + "");
            } else if (stack.size() == 0 || !pairs.get(stack.pop()).equals(aChar + "")) {
                return false;
            }

        }

        if (stack.size() == 0) {
            return true;
        }
        return false;

    }

}
