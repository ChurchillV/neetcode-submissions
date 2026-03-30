class Solution {
    int[] cache;

    public int climbStairs(int n) {
        cache = new int[n];

        for(int i = 0; i < n; i++) {
            cache[i] = -1;
        }

        return dfs(0, n);
    }

    public int dfs(int i, int n) {
        if(i >= n) return (i == n) ? 1 : 0;

        if(cache[i] != -1) { 
            return cache[i]; 
        }
        
        return cache[i] = dfs(i+1, n) + dfs(i+2, n);
    }
}
