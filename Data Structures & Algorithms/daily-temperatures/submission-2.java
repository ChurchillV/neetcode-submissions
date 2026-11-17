class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;
        Stack<int[]> stack = new Stack(); // [temp, index]
        int[] results = new int[size];

        for(int i = 0; i < size; i++) {
            int temp = temperatures[i];
            while(!stack.isEmpty() && temp > stack.peek()[0]) {
                int[] stackTop = stack.pop();
                int diff = i - stackTop[1];
                results[stackTop[1]] = diff;
            }

            stack.push(new int[] {temp, i});
        }

        return results;
    }
}
