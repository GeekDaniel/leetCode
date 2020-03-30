package com.dannystone;

/**
 * Created with IntelliJ IDEA.
 * Description: 逐渐遍历，记录并更新到当前为止的最低售价,最高差价
 *
 * @author: daniel
 * @creed: keep it simple and stupid !
 * @Time: 2020/3/29 11:02 PM
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int maxProfit = -1, minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        if (maxProfit <= 0) {

            return 0;
        }

        return maxProfit;

    }


}
