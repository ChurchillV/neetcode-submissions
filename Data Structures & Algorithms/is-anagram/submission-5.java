class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> sCharMap = new HashMap();
        HashMap<Character, Integer> tCharMap = new HashMap();

        for(int i = 0; i < s.length(); i++) {
            sCharMap.put(s.charAt(i), sCharMap.getOrDefault(s.charAt(i), 0) + 1);
            tCharMap.put(t.charAt(i), tCharMap.getOrDefault(t.charAt(i), 0) + 1);
        }


        return sCharMap.equals(tCharMap);
    }
}
