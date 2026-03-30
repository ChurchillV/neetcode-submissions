class Solution {
    public int countSubstrings(String s) {
        int length = s.length();
        int palindromeCount = 0;

        for(int i = 0; i < length; i++) {
            int left = i;
            int right = i;

            while(left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                palindromeCount++;
                left--;
                right++;
            }

            left = i;
            right = i+1;

            while(left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                palindromeCount++;
                left--;
                right++;
            }
        }

        return palindromeCount;
    }
}
