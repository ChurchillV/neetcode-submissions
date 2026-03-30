class Solution {
    public int[] productExceptSelf(int[] nums) {
        // int product = 1;
        // int zeroCount = 0;

        // for(int num : nums) {
        //     if(num != 0) {
        //         product *= num;
        //     } else {
        //         zeroCount++;
        //     }
        // }


        // if(zeroCount > 1) {
        //     return new int[nums.length];
        // }

        // int[] result = new int[nums.length];

        // for(int i = 0; i < nums.length; i++) {
        //     if(zeroCount > 0) {
        //         result[i] = (nums[i] == 0) ? product : 0;
        //     } else {
        //         result[i] = product / nums[i];
        //     } 
        // }

        // return result;

        int size = nums.length;
        int[] prefix = new int[size];
        int[] suffix = new int[size];
        int[] result = new int[size];

        prefix[0] = 1;
        suffix[size-1] = 1;

        for(int i = 1; i < size; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        for(int i = size - 2; i >= 0; i--) {
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        for(int i = 0; i < size; i++) {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }
}  
