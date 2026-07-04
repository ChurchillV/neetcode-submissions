class Solution {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        ArrayList<String> palindromes = new ArrayList<>();
        recurse(s, 0, palindromes);
        return result;
    }

    public boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        str = str.toLowerCase();

        while(left < right) {
            if(str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public void recurse(String word, int idx, ArrayList<String> palindromes) {
        if(idx >= word.length()) {
            result.add(new ArrayList(palindromes));
            return;
        }

        for(int i = idx; i < word.length(); i++) {
            String str = word.substring(idx, i+1);

            if(isPalindrome(str)) {
                palindromes.add(str);
                recurse(word, i + 1, palindromes);
                palindromes.removeLast();
            }
        }
    }
}
