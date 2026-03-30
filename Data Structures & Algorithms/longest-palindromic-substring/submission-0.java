class Solution {
    public String longestPalindrome(String s) {
        int resultLength = 0;
        int startingIndex = 0;
        int length = s.length();

        for(int i = 0; i < length; i++) {
            int left = i;
            int right = i;

            while(left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                int palindromeLength = right - left + 1;
                 if(palindromeLength > resultLength) {
                    resultLength = palindromeLength;
                    startingIndex = left;
                }
                left--;
                right++;
            }

            left = i;
            right = i+1;

            while(left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                int palindromeLength = right - left + 1;
                if(palindromeLength > resultLength) {
                    resultLength = palindromeLength;
                    startingIndex = left;
                }
                left--;
                right++;
            }
        }

        return s.substring(startingIndex, startingIndex + resultLength);
    }
}
