class Solution {
    public int rob(int[] nums) {
        int size = nums.length;

        if(size == 0) {
            return 0;
        }

        if(size == 1) {
            return nums[0];
        }

        int prev1a = 0;
        int prev2a = 0;

        int prev1b = 0;
        int prev2b = 0;

        for(int i = 0; i < size-1; i++) {
            int current = Math.max(prev2a+nums[i], prev1a);
            prev2a = prev1a;
            prev1a = current;
        }

        for(int i = 1; i < size; i++) {
            int current = Math.max(prev2b+nums[i], prev1b);
            prev2b = prev1b;
            prev1b = current;
        }
        
        return Math.max(prev1a, prev1b);
    }
}
