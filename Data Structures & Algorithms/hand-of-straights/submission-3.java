class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap();
        PriorityQueue<Integer> heap = new PriorityQueue();

        for(int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        for(int card : map.keySet()){
            heap.offer(card);
        }

        while(!heap.isEmpty()) {
            int min = heap.peek();

            for(int i = min; i < min + groupSize; i++) {
                if(!map.containsKey(i)) {
                    return false;
                }

                map.put(i, map.get(i)-1);

                if(map.get(i) == 0) {
                    if(i != heap.peek()) {
                        return false;
                    }

                    heap.poll();
                }
            }
        }

        return true;
    }
}
