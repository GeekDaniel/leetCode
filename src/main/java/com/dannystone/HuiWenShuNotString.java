package com.dannystone;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: daniel
 * @creed: keep it simple and stupid !
 * @Time: 2019/11/9 10:37 AM
 */
public class HuiWenShuNotString {

    private static final int JINZHI = 10;


    private static boolean ifHuiWen(int value) {
        int reversedValue = splitAndReverse(value);
        return value == reversedValue;
    }

    private static int splitAndReverse(int value) {
        List<Integer> list = new ArrayList<>();

        int devide = JINZHI;

        while (value > 0) {
            list.add(value % devide);
            value = value / JINZHI;
        }

        int reversedValue = 0;
        int multiPlier = 1;
        for (int i = 0; i < list.size(); i++) {
            reversedValue += (list.get(i) * multiPlier);
            multiPlier = JINZHI * multiPlier;
        }

        return reversedValue;

    }


    public static void main(String[] args) {
        int value1 = 121;
        System.out.println(value1 + (ifHuiWen(value1) ? " is " : " isn't ") + "回文数");
        int value2 = 1234;
        System.out.println(value2 + (ifHuiWen(value2) ? " is " : " isn't ") + "回文数");
        int value3 = -121;
        System.out.println(value3 + (ifHuiWen(value3) ? " is " : " isn't ") + "回文数");


    }
}
