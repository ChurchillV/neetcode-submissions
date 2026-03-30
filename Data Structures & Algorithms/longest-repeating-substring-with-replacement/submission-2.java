class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freqMap = new HashMap();
        int maxLength = 0;
        int maxCount = 0;
        int size = s.length();
        int left = 0;
        

        for(int right = 0; right < size; right++) {
            int newFrequency = freqMap.getOrDefault(s.charAt(right), 0) + 1;
            freqMap.put(s.charAt(right), newFrequency);
            maxCount = Math.max(maxCount, newFrequency);
            int windowSize = right - left + 1;
            int replacements = windowSize - maxCount;

            if(replacements > k) {
                freqMap.put(s.charAt(left), freqMap.get(s.charAt(left)) - 1);
                left++;
            }

            windowSize = right - left + 1;
            maxLength = Math.max(maxLength, windowSize);
        }

        return maxLength;

    }
}
