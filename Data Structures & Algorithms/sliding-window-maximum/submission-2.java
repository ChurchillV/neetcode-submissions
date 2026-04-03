class Solution {

    // Brute force
    public int[] maxSlidingWindow(int[] nums, int k) {
        int resSize = nums.length - k + 1;
        int[] result = new int[resSize];
        int currentMax = Integer.MIN_VALUE;

        for(int right = 0; right < k; right++) {
            currentMax = Math.max(currentMax, nums[right]);
        }

        result[0] = currentMax;
        currentMax = Integer.MIN_VALUE;
        
        int right = k;
        int left = 1;
        int currIdx = 1;
        while(right < nums.length) {
            for(int i = left; i <= right; i++) {
                currentMax = Math.max(currentMax, nums[i]);
            }
            result[currIdx] = currentMax;
            right++;
            currIdx++;
            left++;
            currentMax = Integer.MIN_VALUE;
        }

        return result;
    }
}
