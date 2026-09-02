class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, ArrayList<int[]>> map = new HashMap(); // node, [target, time]
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[0], b[0])); // time, node

        for(int[] time : times) {
            map.computeIfAbsent(time[0], t -> new ArrayList()).add(new int[] { time[2], time[1] });
        }

        heap.offer(new int[] { 0, k });
        Set<Integer> visited = new HashSet();
        int min = 0;

        while(!heap.isEmpty()) {
            int[] details = heap.poll();
            int node = details[1];
            int weight = details[0];

            if(visited.contains(node)) {
                continue;
            }

            visited.add(node);
            min = Math.max(min, weight);
            if(map.containsKey(node)) {
                for(int[] pair : map.get(node)) {
                    int subNode = pair[1];
                    int subWeight = pair[0];

                    if(!visited.contains(subNode)) {
                        heap.offer(new int[] { weight + subWeight, subNode });
                    }
                }
            }
        }

        return (visited.size() == n) ? min : -1;
    }
}
