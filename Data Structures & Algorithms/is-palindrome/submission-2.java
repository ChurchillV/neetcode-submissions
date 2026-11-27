class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sCopy = new StringBuilder();

        for(Character c : s.toCharArray()) {
            if(Character.isLetterOrDigit(c)) {
                sCopy.append(c);
            }
        }

        String newString = sCopy.toString().toLowerCase();

        int l, r;
        if(newString.length() % 2 == 0) {
            l = (newString.length()/2) - 1;
            r = l+1;
        } else {
            l = newString.length()/2;
            r = l;
        }

        while(l >= 0 && r <= newString.length()-1) {
            if(newString.charAt(l) != newString.charAt(r)) {
                return false;
            }
            l--;
            r++;
        }

        return true;
    }
}
