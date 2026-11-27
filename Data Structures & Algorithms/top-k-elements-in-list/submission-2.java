class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Use a priority queue that uses the frequencies as the main comparison
        // Have a freq map

        Map<Integer, Integer> freqMap = new HashMap(); // [integer, freq]
        for(int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(
            (a,b) -> Integer.compare(b[1], a[1])
        );

        for(Integer num : freqMap.keySet()) {
            queue.offer(new int[] { num, freqMap.get(num) });
        }

        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = queue.poll()[0];
        }

        return result;
    }
}
