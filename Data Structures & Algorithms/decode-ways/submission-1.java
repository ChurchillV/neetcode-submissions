class Solution {

    int[] memo;

    public int dfs(int i, String s) {
        int result;

        if(i == s.length()) {
            return 1;
        }

        if (s.charAt(i) == '0') {
            return 0;
        }

        if(memo[i] != -1) {
            return memo[i];
        }

        result = dfs(i+1, s);

        if(i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6'))) {
            result += dfs(i+2, s);
        }

        return memo[i] = result;
    }

    public int numDecodings(String s) {
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dfs(0, s);
    }
}
