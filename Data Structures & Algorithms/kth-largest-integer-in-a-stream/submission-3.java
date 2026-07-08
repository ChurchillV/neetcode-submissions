class KthLargest {

    PriorityQueue<Integer> queue;
    int size;

    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>();
        
        for(int num : nums) {
            queue.offer(num);
        }

        size = k;

        while(queue.size() > size) {
            queue.poll();
        }
    }
    
    public int add(int val) {
        queue.offer(val);

        if(queue.size() > size) {
            queue.poll();
        }

        return queue.peek();
    }
}
