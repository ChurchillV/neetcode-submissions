class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> freqMapS = new HashMap<>();
        HashMap<Character, Integer> freqMapT = new HashMap<>();

        int size = s.length();
        
        for(int i = 0; i < size; i++) {
            freqMapS.put(s.charAt(i), freqMapS.getOrDefault(s.charAt(i), 0)+1);
            freqMapT.put(t.charAt(i), freqMapT.getOrDefault(t.charAt(i), 0)+1);
        }

        return freqMapS.equals(freqMapT);
    }
}
