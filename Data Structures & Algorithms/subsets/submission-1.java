class Solution {
    public List<List<Integer>> result = new ArrayList<>();
    public List<Integer> subset = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);

        return result;
    }

    public void dfs(int i, int[] nums) {
        if(i >= nums.length) {
            result.add(new ArrayList(subset));
            return;
        }

        subset.add(nums[i]);
        dfs(i+1, nums);

        subset.removeLast();
        dfs(i+1, nums);
    }
}
