class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] minCoins = new int[amount + 1];
        Arrays.fill(minCoins, amount + 1);

        minCoins[0] = 0;

        for(int i = 1; i <= amount; i++) {
            int min = amount + 1;

            for(int coin : coins) {
                int diff = i - coin;
                if(diff < 0) {
                    break;
                }

                min = Math.min(min, minCoins[diff] + 1);
            }

            minCoins[i] = min;
        }

        if(minCoins[amount] < amount + 1) {
            return minCoins[amount];
        } else {
            return -1;
        }
    }
}
