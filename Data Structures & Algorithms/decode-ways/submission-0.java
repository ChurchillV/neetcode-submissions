class Solution {

    public int dfs(int i, String s) {
        int result;

        if(i == s.length()) {
            return 1;
        }

        if (s.charAt(i) == '0') {
            return 0;
        }

        result = dfs(i+1, s);

        if(i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6'))) {
            result += dfs(i+2, s);
        }

        return result;
    }

    public int numDecodings(String s) {
        return dfs(0, s);
    }
}
