class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;
        int[] results = new int[size];

        for(int i = 0; i < size; i++) {
            int days = 0;
            int j = i+1;
            boolean foundWarmerDay = false;
            while(j < size) {
                if(temperatures[j] <= temperatures[i]) {
                    days++;
                } else {
                    foundWarmerDay = true;
                    break;
                }

                j++;
            }
            results[i] = foundWarmerDay ? days+1 : 0;
        }

        return results;
    }
}
