class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Set<Integer> set = new HashSet();

        for(int i = 0; i < triplets.length; i++) {
            if(
                triplets[i][0] > target[0] ||
                triplets[i][1] > target[1] ||
                triplets[i][2] > target[2]
            ) {
                continue;
            }

            if(triplets[i][0] == target[0]) set.add(0);
            if(triplets[i][1] == target[1]) set.add(1);
            if(triplets[i][2] == target[2]) set.add(2);
        }

        return set.size() == 3;
    }
}