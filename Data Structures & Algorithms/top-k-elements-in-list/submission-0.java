class Solution {
    static class Compare implements Comparator<int[]> {
        public int compare(int[] p1, int[] p2) {
            if(p1[1] == p2[1]) {
                return Integer.compare(p2[0], p1[0]);
            }

            return Integer.compare(p2[1], p1[1]);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        ArrayList<int[]> freqArray = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            freqArray.add(new int[]{entry.getKey(), entry.getValue()});
        }

        freqArray.sort(new Compare());

        int[] result = new int[k];

        for(int i = 0; i < k; i++) {
            result[i] = freqArray.get(i)[0];
        }

        return result;
    }
}
