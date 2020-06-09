package com.dannystone;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 结题思路：
 * 贪婪，如果后一天涨了，那我今天肯定要买
 *
 * @author: daniel
 * @creed: keep it simple and stupid !
 * @Time: 2020/3/29 11:02 PM
 */
public class MaxProfitMulti {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int priceToday = prices[i];
            int priceTomorrow = prices[i + 1];
            if (priceTomorrow > priceToday) {
                profit += priceTomorrow - priceToday;
            }
        }
        return profit;


    }


}
