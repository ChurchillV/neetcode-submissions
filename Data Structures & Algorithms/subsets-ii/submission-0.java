class Solution {
    public List<Integer> subset = new ArrayList<>();
    public List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(0, nums);

        return result;
    }

    public void dfs(int i, int[] nums) {
        if(i >= nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        dfs(i+1, nums);

        subset.removeLast();
        while((i+1 < nums.length) && (nums[i] == nums[i+1])) {
            i++;
        }
        dfs(i+1, nums);
    }
}
