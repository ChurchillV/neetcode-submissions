class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Set<Integer> set = new HashSet();

        for(int[] t : triplets) {
            if(
                t[0] > target[0] ||
                t[1] > target[1] ||
                t[2] > target[2]
            ) {
                continue;
            }

            if(t[0] == target[0]) set.add(0);
            if(t[1] == target[1]) set.add(1);
            if(t[2] == target[2]) set.add(2);
        }

        return set.size() == 3;
    }
}
