class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];

        for(char task : tasks) {
            count[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());

        for(int cnt : count) {
            if(cnt > 0) {
                maxHeap.add(cnt);
            }
        }

        int time = 0;
        Queue<int[]> queue = new LinkedList();

        while(!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;

            if(maxHeap.isEmpty()) {
                time = queue.peek()[1];
            } else {
                int cnt = maxHeap.poll() - 1;
                if(cnt > 0) {
                    queue.add(new int[] {cnt, time + n});
                }
            }

            if(!queue.isEmpty() && queue.peek()[1] == time) {
                maxHeap.add(queue.poll()[0]);
            }
        }

        return time;
    }
}
