class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue(Collections.reverseOrder());

        for(int stone : stones) {
            queue.offer(stone);
        }

        while(queue.size() > 1) {
            int s1 = queue.poll();
            int s2 = queue.poll();

            int diff = s1 - s2;

            if(diff > 0) {
                queue.offer(diff);
            }
        }

        return queue.isEmpty() ? 0 : queue.peek();
    }
}
