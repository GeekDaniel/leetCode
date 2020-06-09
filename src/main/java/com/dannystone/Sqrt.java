package com.dannystone;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: daniel
 * @creed: keep it simple and stupid !
 * @Time: 2020/6/9 5:25 PM
 */
public class Sqrt {
    public static int mySqrt(int x) {
        int result = 0;
        int l = 1, r = x;
        while (l <= r) {
            int mid = (l + r)  / 2;
            if (mid * mid <= (long)x) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(16));
        System.out.println(mySqrt(1));
        System.out.println(mySqrt(5));
        System.out.println(mySqrt(3));
        System.out.println(mySqrt(7));

    }
}
