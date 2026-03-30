class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freqMap = new HashMap();
        int maxLength = 0;
        int maxCount = 0;
        int left = 0;

        for(int right = 0; right < s.length(); right++) {
            int charFrequency = freqMap.getOrDefault(s.charAt(right), 0) + 1;
            freqMap.put(s.charAt(right), charFrequency);

            maxCount = Math.max(charFrequency, maxCount);

            int windowLength = right - left + 1;

            if((windowLength - maxCount) > k) {
                int leftCharFrequency = freqMap.get(s.charAt(left));
                freqMap.put(s.charAt(left), leftCharFrequency - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
