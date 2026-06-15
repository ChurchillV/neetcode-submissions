class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxArea = Math.min(heights[left], heights[right]) * (right - left);

        while(left < right) {
            if(heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }

            maxArea = Math.max(maxArea, Math.min(heights[left], heights[right]) * (right - left));
        }

        return maxArea;
    }
}
