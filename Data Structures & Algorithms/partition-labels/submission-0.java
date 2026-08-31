class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap();

        for(Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int start = 0;
        int rem = 0;
        Set<Character> set = new HashSet();

        List<Integer> result = new ArrayList();

        for(int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);

            if(rem == 0 || !set.contains(ch)) {
                rem += map.get(ch) - 1;
                set.add(ch);
            } else {
                rem--;
            }

            map.put(ch, map.get(ch) - 1);

            if(rem == 0) {
                result.add(i - start + 1);
                start = i + 1;
                set = new HashSet();
            }
        }

        return result;
    }
}
