class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int curr = 0;

        for(int num : nums) {
            if(curr < 0) {
                curr = 0;
            }

            curr += num;
            maxSum = Math.max(curr, maxSum);
        }

        return maxSum;
    }
}
