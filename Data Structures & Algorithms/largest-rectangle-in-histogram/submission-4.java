class Solution {
    public int largestRectangleArea(int[] heights) {
        int size = heights.length;
        int maxArea = 0;
        Stack<int[]> stack = new Stack();

        for(int i = 0; i < size; i++) {
            int start = i;
            while(!stack.isEmpty() && heights[i] < stack.peek()[0]) {
                int[] top = stack.pop();
                int width = i - top[1];
                int area = top[0] * width;
                maxArea = Math.max(area, maxArea);
                start = top[1];
            }
            stack.push(new int[] {heights[i], start});
        }

        while(!stack.isEmpty()) {
            int[] top = stack.pop();
            int width = size - top[1];
            int area = width * top[0];
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
