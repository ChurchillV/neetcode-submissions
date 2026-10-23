class Solution {

    private Map<String, Integer> dp = new HashMap();

    public int maxProfit(int[] prices) {
        return dfs(0, true, prices);
    }

    private int dfs(int i, boolean isBuying, int[] prices) {
        int maxLen = prices.length;

        if(i >= maxLen) {
            return 0;
        }
        
        int buyOrSell = isBuying ? 1 : 0;
        String key = Arrays.toString(new int[]{i, buyOrSell});

        if(dp.containsKey(key)) {
            return dp.get(key);
        }

        int cooldown = dfs(i+1, isBuying, prices);
        if(isBuying) {
            int buy = dfs(i+1, !isBuying, prices) - prices[i];
            dp.put(key, Math.max(buy, cooldown));
        } else {
            int sell = dfs(i+2, !isBuying, prices) + prices[i];
            dp.put(key, Math.max(sell, cooldown));
        }

        return dp.get(key);
    }
}
