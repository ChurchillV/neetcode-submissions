class Solution {
    public int[] plusOne(int[] digits) {
        // Start iterating from the last value
        // Increment by one and append ans % 10 to a string, carry over the ans to the next
        String res = "";
        int carry = 1;

        for(int i = digits.length-1; i >= 0; i--) {
            int sum = digits[i] + carry;
            int ans = (sum) % 10;
            // System.out.println(ans);
            carry = (sum) / 10;
            // System.out.println(carry);
            res = ans + res;
            // System.out.println(res);
        }

        if(carry > 0) {
            res = carry + res;
        }

        int[] result = new int[res.length()];
        for(int i = 0; i < res.length(); i++) {
            result[i] = Integer.parseInt(String.valueOf(res.charAt(i)));
        }

        return result;
    }
}
