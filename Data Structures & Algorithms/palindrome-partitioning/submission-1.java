class Solution {

    public List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        ArrayList<String> palindromes = new ArrayList();
        recurse(0, s, palindromes);
        return result;
    }

    public boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while(left < right) {
            if(str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public void recurse(int idx, String word, ArrayList<String> palindromes) {
        if(idx >= word.length()) {
            result.add(new ArrayList(palindromes));
            return;
        }

        for(int i = idx; i < word.length(); i++) {
            String str = word.substring(idx, i+1);

            if(isPalindrome(str)) {
                palindromes.add(str);
                recurse(i + 1, word, palindromes);
                palindromes.removeLast();
            }
        }
    }
}
