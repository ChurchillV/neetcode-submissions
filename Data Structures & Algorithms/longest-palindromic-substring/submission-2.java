class Solution {
    public String longestPalindrome(String s) {
        int maxLength = 0;
        int startIndex = 0;
        int size = s.length();

        for(int i = 0; i < size; i++) {
            int left = i;
            int right = i;

            while(left >= 0 && right < size && s.charAt(left) == s.charAt(right)) {
              int length = right - left + 1;

              if(length > maxLength) {
                maxLength = length;
                startIndex = left;
              }  

              left--;
              right++;
            }

            
            left = i;
            right = i + 1;
            while(left >= 0 && right < size && s.charAt(left) == s.charAt(right)) {
              int length = right - left + 1;

              if(length > maxLength) {
                maxLength = length;
                startIndex = left;
              }  

              left--;
              right++;
            }
        }

        return s.substring(startIndex, startIndex + maxLength);
    }
}
