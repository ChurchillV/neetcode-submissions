class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) {
            return "";
        }

        if(s.equals(t)) {
            return s;
        }

        Map<Character, Integer> tFreqMap = new HashMap();
        Map<Character, Integer> window = new HashMap();

        for(int i = 0; i < t.length(); i++) {
            tFreqMap.put(t.charAt(i), tFreqMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int have = 0;
        int need = tFreqMap.keySet().size();

        int[] result = new int[]{ -1, -1 }; // left, right
        int resLen = s.length() + 1;

        int left = 0;

        for(int right = 0; right < s.length(); right++) {
            Character ch = s.charAt(right);
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            if(tFreqMap.containsKey(ch) && window.get(ch) == tFreqMap.get(ch)) {
                have++;
            }

            while(have == need) {
                if((right - left + 1) < resLen) {
                    result = new int[] {left, right};
                    resLen = (right - left + 1);
                }

                window.put(s.charAt(left), window.getOrDefault(s.charAt(left), 1) - 1);

                if(tFreqMap.containsKey(s.charAt(left)) && (window.get(s.charAt(left)) < tFreqMap.get(s.charAt(left)))) {
                    have--;
                }

                left++; 
            }
        }

        int startIndex = result[0];
        int endIndex = result[1];

        return resLen != s.length() + 1 ? s.substring(startIndex, endIndex+1) : "";
    }
}
