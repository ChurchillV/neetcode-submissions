class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList();
        int SIZE = intervals.length;

        for(int i = 0; i < SIZE; i++) {
            // Insert new interval before
            // Then speedrun insertion
            if(intervals[i][0] > newInterval[1]) {
                result.add(newInterval);
                int currentIdx = i + 1;
                
                while(currentIdx < SIZE+1) {
                    result.add(intervals[currentIdx-1]);
                    currentIdx++;
                }

                return result.stream()
                            .toArray(int[][]::new);
            }

            // Insert actual interval and skip new interval
            else if(intervals[i][1] < newInterval[0]) {
                result.add(intervals[i]);
            }

            // Merge interval
            else {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            }
        }

        result.add(newInterval);
        return result.stream()
                    .toArray(int[][]::new);
    }
}
