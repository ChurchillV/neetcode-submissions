class Solution {
    int[] cache;

    public int minCostClimbingStairs(int[] cost) {
        cache = new int[cost.length];
        Arrays.fill(cache, -1);

        return Math.min(dfs(cost, 0), dfs(cost, 1));
    }

    public int dfs(int[] cost, int i) {
        if(i >= cost.length) {
            return 0;
        }

        if(cache[i] != -1) {
            return cache[i]; 
        }

        cache[i] = cost[i] + Math.min(dfs(cost, i+1), dfs(cost, i+2));
        return cache[i];
    }
}
