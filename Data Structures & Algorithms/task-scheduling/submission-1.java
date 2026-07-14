class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] taskFrequencies = new int[26];

        for(char task : tasks) {
            taskFrequencies[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());

        for(int frequency : taskFrequencies) {
            if(frequency > 0) {
                maxHeap.offer(frequency);
            }
        }

        Queue<int[]> taskQueue = new LinkedList(); // { frequency, time of return }
        int time = 0;

        while(!maxHeap.isEmpty() || !taskQueue.isEmpty()) {
            time++;

            if(maxHeap.isEmpty()) {
                time = taskQueue.peek()[1];
            } else {
                int topTaskFrequency = maxHeap.poll() - 1;

                if(topTaskFrequency > 0) {
                    taskQueue.add(new int[] { topTaskFrequency, time + n });
                }
            }

            if(!taskQueue.isEmpty() && taskQueue.peek()[1] == time) {
                maxHeap.offer(taskQueue.poll()[0]);
            }
        }

        return time;
    }
}
