class Solution {
    public int maxProfit(int[] prices) {
        int b = 0;
        int s = 1;
        int maxProfit = 0;

        while(s < prices.length) {
            if(prices[b] < prices[s]) {
                maxProfit = Math.max(prices[s] - prices[b], maxProfit);
            } else {
                b = s;
            }
            s++;
        }

        return maxProfit;
    }
}
