class Solution {
    public int jump(int[] nums) {
        int result = 0;
        int left = 0, right = 0; // In the beginning our start jump range is nums[0]

        while(right < nums.length - 1) { // While we're in the range and yet to reach the end
            int farthest = 0;
            for(int i = left; i < right+1; i++) {
                farthest = Math.max(farthest, i + nums[i]); // Longest jump we can take
            }

            left = right+1; // Move to the start of the next jump range
            right = farthest; // End of the next jump range
            result += 1; // We've taken another step, record it
        }

        return result;
    }
}
