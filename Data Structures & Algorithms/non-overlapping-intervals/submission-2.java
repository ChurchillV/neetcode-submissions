class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a,b)->Integer.compare(a[1], b[1]));

        for(int[] interval : intervals) {
            queue.offer(interval);
        }

        int count = 0;
        int min = Integer.MIN_VALUE;
        
        while(!queue.isEmpty()) {
            int[] interval = queue.poll();

            if(interval[0] >= min) {
                min = interval[1];
            } else {
                count++;
            }
        }

        return count;
    }
}
