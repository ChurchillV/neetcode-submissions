class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, ArrayList<int[]>> map = new HashMap(); // node: [[target, weight]

        for(int[] time : times) {
            map.computeIfAbsent(time[0], t -> new ArrayList()).add(new int[] { time[2], time[1] });
        }

        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[0], b[0]));
        Set<Integer> visited = new HashSet();
        int minTime = 0;
        heap.offer(new int[] { 0, k });

        while(!heap.isEmpty()) {
            int[] details = heap.poll();
            int node = details[1];
            int weight = details[0];

            if(visited.contains(node)) {
                continue;
            }

            visited.add(node);
            minTime = Math.max(minTime, weight);

            if(map.containsKey(node)) {
                for(int[] pair : map.get(node)) {
                    int subNode = pair[1];
                    int subWeight = pair[0];

                    if(!visited.contains(subNode)) {
                        heap.offer(new int[]{ weight + subWeight, subNode });
                    }
                }
            }
        }

        return visited.size() == n ?
               minTime             :
               -1; 
    }
}
