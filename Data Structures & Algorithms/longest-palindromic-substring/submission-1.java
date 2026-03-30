class Solution {
    public String longestPalindrome(String s) {
         int length = s.length();
        int startingIndex = 0;
        int maxLength = 0;

        for(int i = 0; i < length; i++) {
            int left = i;
            int right = i;

            while(left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                int palindromeLength = right - left + 1;

                if(palindromeLength > maxLength) {
                    maxLength = palindromeLength;
                    startingIndex = left;
                }

                left--;
                right++;
            }

            left = i;
            right = i + 1;

            while(left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                int palindromeLength = right - left + 1;

                if(palindromeLength > maxLength) {
                    maxLength = palindromeLength;
                    startingIndex = left;
                }

                left--;
                right++;
            }
        }

        return s.substring(startingIndex, maxLength + startingIndex);
    }
}
