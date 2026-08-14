class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));

        int[][] queriesWithIndices = new int[queries.length][2]; // query, index 

        for(int i = 0; i < queries.length; i++) {
            queriesWithIndices[i] = new int[] { queries[i], i };
        }

        Arrays.sort(queriesWithIndices, (a,b)-> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> {
            int cmp1 = Integer.compare(a[0], b[0]); // duration
            if(cmp1 != 0) return cmp1;

            return Integer.compare(a[1], b[1]); // end value
        });

        int[] result = new int[queries.length];
        int i = 0;

        for(int[] query : queriesWithIndices) {
            while(i < intervals.length && intervals[i][0] <= query[0]) {
                int start = intervals[i][0];
                int end = intervals[i][1]; 
                minHeap.offer(new int[] {end - start + 1, end});
                i++;
            }

            while(!minHeap.isEmpty() && minHeap.peek()[1] < query[0]) {
                minHeap.poll();
            }

            result[query[1]] = minHeap.isEmpty() ? -1 : minHeap.peek()[0];
        }

        return result;
    }
}
