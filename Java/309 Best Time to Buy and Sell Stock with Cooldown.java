public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        // idea : state mechine
        // s0 = ready to buy a stock, transactions ends with cooldown
        // s1 = holding a stock, transactions ends with buy or cooldown
        // s2 = just sell a stock, transactions ends with sell
        // transition : 
        //      s0[i] = max{s0[i - 1], s2[i - 1]}
        //      s1[i] = max{s1[i - 1], s0[i - 1] - prices[i]}
        //      s2[i] = s1[i - 1] + prices[i]
        // because s1 does not appear on right hand, s2 could be merged:
        //      s0[i] = max{s0[i - 1], s1[i - 2] + prices[i - 1]}
        //      s1[i] = max{s1[i - 1], s0[i - 1] - prices[i]}
        // to reduce memory, we only need to store s0[i - 1], s1[i - 1], s1[i - 2];
        // we need to initialize s0[0], s1[0], s1[-1] = tmp
        int s0 = 0, s1 = -prices[0], tmp = Integer.MIN_VALUE;
        for(int i = 1; i < prices.length; i++){
            int oldS1 = s1;
            s1 = Math.max(s1, s0 - prices[i]);
            s0 = Math.max(s0, tmp + prices[i - 1]);
            tmp = oldS1;
        }
        return Math.max(s0, s1 + prices[prices.length - 1]);
    }
}