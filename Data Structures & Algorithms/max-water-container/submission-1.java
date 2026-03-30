class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;

        int distance = right - left;
        int maxArea = Math.min(heights[left], heights[right]) * distance;

        while(left < right) {
            if(heights[left] > heights[right]) {
                right--;
            } else {
                left++;
            }
            distance = right - left;
            maxArea = Math.max(Math.min(heights[left], heights[right]) * distance, maxArea);
        }

        return maxArea;
    }
}
