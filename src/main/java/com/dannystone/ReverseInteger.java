package com.dannystone;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: daniel
 * @creed: keep it simple and stupid !
 * @Time: 2020/3/30 10:43 PM
 */
public class ReverseInteger {

    public int reverse(int x) {
        boolean minus = x < 0;
        x = Math.abs(x);

        long reversed = 0;
        while (x / 10 != 0 || x % 10 != 0) {

            reversed = reversed * 10;
            //末尾0 舍去
            if (x % 10 != 0 || reversed != 0) {
                reversed += x % 10;
            }
            x = x / 10;

        }

        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
            return 0;
        } else {
            return minus ? -(int) reversed : (int) reversed;
        }

    }
}
