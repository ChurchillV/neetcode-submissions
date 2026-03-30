class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        Stack<int[]> tempStack = new Stack(); // [index, temperature]

        for(int i = 0; i < length; i++) {
            int temperature = temperatures[i];

            while(!tempStack.isEmpty() && (temperature > tempStack.peek()[1])) {
                int[] currentTemp = tempStack.pop();
                int days = i - currentTemp[0];
                result[currentTemp[0]] = days;
            }

            tempStack.push(new int[] {i, temperature});
        }

        return result;
    }
}
