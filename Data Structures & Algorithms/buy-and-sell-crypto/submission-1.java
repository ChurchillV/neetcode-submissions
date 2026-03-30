class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int left = 0;
        int right = 1;

        while(right < prices.length && left < right) {

            if(prices[right] - prices[left] < 0) {
                left = right;
            } else {
                max = Math.max(prices[right] - prices[left], max);
            }
            right++;
        }

        return max;
    }
}