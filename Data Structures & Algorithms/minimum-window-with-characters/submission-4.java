class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) {
            return "";
        }

        if(s.equals(t)) {
            return s;
        }

        Map<Character, Integer> tFreqMap = new HashMap();

        for(int i = 0; i < t.length(); i++) {
            Character ch = t.charAt(i);
            tFreqMap.put(ch, tFreqMap.getOrDefault(ch, 0) + 1);
        }

        int need = tFreqMap.keySet().size();

        int have = 0;
        Map<Character, Integer> windowMap = new HashMap();

        int startIdx = -1;
        int minSize = s.length() + 1;

        int left = 0;
        int sSize = s.length();

        for(int right = 0; right < sSize; right++) {
            Character curr = s.charAt(right);
            windowMap.put(curr, windowMap.getOrDefault(curr, 0) + 1);

            if(tFreqMap.containsKey(curr) && tFreqMap.get(curr) == windowMap.get(curr)) {
                    have++;
            }

            while(have == need) {
                int winSize = right - left + 1;
                if(winSize < minSize) {
                    startIdx = left;
                    minSize = winSize;
                }
                
                Character leftCh = s.charAt(left);
                windowMap.put(leftCh, windowMap.getOrDefault(leftCh, 1) - 1);

                if(tFreqMap.containsKey(leftCh) && (windowMap.get(leftCh) < tFreqMap.get(leftCh))) {
                    have--;
                }

                left++;
            }
        }

        return startIdx == -1 ? "" : s.substring(startIdx, startIdx + minSize);
    }
}
