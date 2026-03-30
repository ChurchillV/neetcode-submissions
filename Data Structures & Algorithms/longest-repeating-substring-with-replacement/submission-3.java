class Solution {
    public int characterReplacement(String s, int k) {
        int maxFrequency = 0;
        int maxCount = 0;
        int left = 0;
        int size = s.length();
        Map<Character , Integer> freqMap = new HashMap();
        
        for(int right = 0; right < size; right++) {
            freqMap.put(s.charAt(right), freqMap.getOrDefault(s.charAt(right), 0) + 1);
            int newCharFrequency = freqMap.get(s.charAt(right));
            
            maxCount = Math.max(newCharFrequency, maxCount);
            int windowSize = right - left + 1;
            int replacementCount = windowSize - maxCount;
            
            if(replacementCount > k) {
                freqMap.put(s.charAt(left), freqMap.getOrDefault(s.charAt(left), 1) - 1);
                left++;
            }
            
            windowSize = right - left + 1;
            maxFrequency = Math.max(maxFrequency, windowSize);
        }
        
        return maxFrequency;
    }
}
