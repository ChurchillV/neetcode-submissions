class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] letters = new int[27];

        for(Character ch : s.toCharArray()) {
            letters[ch - 'a' + 1]++;
        }

        int rem = 0;
        int start = 0;

        Set<Character> set = new HashSet();
        List<Integer> result = new ArrayList();

        for(int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);

            if(rem == 0 || !set.contains(ch)) {
                rem += letters[ch - 'a' + 1] - 1;
                set.add(ch);
            } else {
                rem--;
            }

            if(rem == 0) {
                result.add(i - start + 1);
                start = i + 1;
                set = new HashSet();
            }

            letters[ch - 'a' + 1]--;
        }

        return result;
    }
}
