/* 121	Best Time to Buy and Sell Stock
*/

// Say you have an array for which the ith element is the price of a given stock on day i.
// If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
// design an algorithm to find the maximum profit.

public class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for(int i = 0; i< prices.length; i++){
            minPrice = Math.min(minPrice, prices[i]);
            maxprofit = Math.max(maxprofit, prices[i] - minPrice);
        }
        return maxprofit;
    }
}