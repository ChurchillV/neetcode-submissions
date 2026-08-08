class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int SIZE = intervals.length;
        List<int[]> intervalList = new ArrayList();

        for(int i = 0; i < SIZE; i++) {

            // Insert new interval before
            if(newInterval[1] < intervals[i][0]) {
                intervalList.add(newInterval);
                // Fill result and return
                int slot = i+1;
                while(slot < SIZE+1) {
                    intervalList.add(intervals[slot-1]);
                    slot++;
                }

                return intervalList.stream()
                                    .toArray(int[][]::new);
            }

            // Insert current interval
            else if(newInterval[0] > intervals[i][1]) {
                intervalList.add(intervals[i]);
            }

            // In case of overlap
            else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }

        intervalList.add(newInterval);
        return intervalList.stream()
                            .toArray(int[][]::new);
    }
}
