class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0) {
            List<List<Integer>> outerList = new ArrayList<>();
            List<Integer> innerEmptyList = new ArrayList<>();
            outerList.add(innerEmptyList);

            return outerList;
        } 

        List<List<Integer>> permutations = permute(Arrays.copyOfRange(nums, 1, nums.length));
        List<List<Integer>> result = new ArrayList<>();

        for(List perm : permutations) {
            for(int i = 0; i < perm.size() + 1; i++) {
                List<Integer> permCopy = new ArrayList<>(perm);
                permCopy.add(i, nums[0]);
                result.add(permCopy);
            }
        }

        return result;
    }
}
