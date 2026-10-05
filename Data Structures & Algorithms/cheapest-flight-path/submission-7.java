class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];

        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        int stops = 0;

        while(stops <= k) {
            int[] tempPrices = prices.clone();
            boolean changed = false;
            for(int[] flight : flights) {
                int start = flight[0];
                int end = flight[1];
                int flightPrice = flight[2];

                if(prices[start] == Integer.MAX_VALUE) {
                    continue;
                }

                if((prices[start] + flightPrice) < tempPrices[end]) {
                    tempPrices[end] = prices[start] + flightPrice;
                    changed = true;
                }
            }
            stops++;


            if(changed) {
                prices = tempPrices;
            } else {
                break;
            }
        }

        return prices[dst] != Integer.MAX_VALUE ? prices[dst] : -1;
    }
}
