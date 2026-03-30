class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroCount = 0;

        for(int num : nums) {
            if(num != 0) {
                product *= num;
            } else {
                zeroCount++;
            }
        }


        if(zeroCount > 1) {
            return new int[nums.length];
        }

        int[] result = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            if(zeroCount > 0) {
                result[i] = (nums[i] == 0) ? product : 0;
            } else {
                result[i] = product / nums[i];
            } 
        }

        return result;
    }
}  
