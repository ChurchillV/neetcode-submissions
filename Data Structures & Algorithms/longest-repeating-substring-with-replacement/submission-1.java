class Solution {
    public int characterReplacement(String s, int k) {
         Map<Character, Integer> freqMap = new HashMap<>();
        int maxLength = 0;
        int maxCount = 0;
        int left = 0;

        for(int right = 0; right < s.length(); right++) {
            int newFrequency = freqMap.getOrDefault(s.charAt(right), 0) + 1;
            freqMap.put(s.charAt(right), newFrequency);
            maxCount = Math.max(newFrequency, maxCount);

            int windowLength = right - left + 1;
            if(windowLength - maxCount > k) {
                int newLeftCharFrequency = freqMap.get(s.charAt(left)) - 1;
                freqMap.put(s.charAt(left), newLeftCharFrequency);
                left++;
            }

            windowLength = right - left + 1;
            maxLength = Math.max(maxLength, windowLength);
        }

        return maxLength;
    }
}
