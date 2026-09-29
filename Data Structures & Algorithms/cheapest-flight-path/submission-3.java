class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];

        for(int i = 0; i < n; i++) {
            if(i == src) {
                prices[i] = 0;
                continue;
            }

            prices[i] = Integer.MAX_VALUE;
        }

        int stops = 0;

        while(stops <= k) {
        int[] tempPrices = Arrays.copyOf(prices, n);

            for(int[] flight : flights) {
                int strt = flight[0];
                int end = flight[1];
                int price = flight[2];

                if(prices[strt] == Integer.MAX_VALUE) {
                    continue;
                }

                if(prices[strt] + price < tempPrices[end]) {
                    tempPrices[end] = prices[strt] + price;
                }
            }
            stops++;
            prices = Arrays.copyOf(tempPrices, n);
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
