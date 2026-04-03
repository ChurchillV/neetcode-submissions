class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque();
        int size = nums.length;
        int[] result = new int[size-k+1];
        int currIdx = 0;


        for(int right = 0; right < size; right++) {
            while(!deque.isEmpty() && nums[right] > nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(right);

            if(deque.peekFirst() <= right-k) {
                deque.pollFirst();
            }

            if(right >= k-1) {
                result[currIdx++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
