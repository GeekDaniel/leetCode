package com.dannystone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: daniel
 * @creed: keep it simple and stupid !
 * @Time: 2019/11/9 1:06 AM
 */
public class HuiWenShu {
    //1.拆位
    //2.倒叙
    //3.值相等
    private static boolean ifHuiWen(int value) {

        //1.拆位
        char[] chars = Integer.toString(value).toCharArray();

        //2.倒叙
        char[] reversed = new char[chars.length];
        for (int i = chars.length - 1; i >= 0; i--) {
            reversed[chars.length - 1 - i] = chars[i];
        }

        //3.值相等
        return new String(chars).equals(new String(reversed));
    }

    public static void main(String[] args) {
        int value1 = 121;
        System.out.println(value1 +(ifHuiWen(value1)?" is ":" isn't ")+"回文数");
        int value2 = 1234;
        System.out.println(value2 +(ifHuiWen(value2)?" is ":" isn't ")+"回文数");
        int value3 = -121;
        System.out.println(value3 +(ifHuiWen(value3)?" is ":" isn't ")+"回文数");


    }
}
