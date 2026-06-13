class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        List<int[]> freqArr = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            freqArr.add(new int[] {entry.getKey(), entry.getValue()});
        }

        freqArr.sort((a, b) -> b[1] - a[1]);

        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = freqArr.get(i)[0];
        }

        return result;
    }
}
