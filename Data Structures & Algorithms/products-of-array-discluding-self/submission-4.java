class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int[] result = new int[nums.length];
        int zeroCount = 0;

        for(int num : nums) {
            if(num != 0) {
                prod *= num;
            } else {
                zeroCount++;
            }
        }

        if(zeroCount > 1) {
            Arrays.fill(result, 0);
            return result;
        }

        for(int i = 0; i < nums.length; i++) {
            result[i] = nums[i] == 0 ? prod : zeroCount > 0 ? 0 : prod/nums[i];
        }

        return result;
    }
}  
