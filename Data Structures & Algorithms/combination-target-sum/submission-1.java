class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> current = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(0, target, 0, nums);
        return result;
    }

    public void dfs(int i, int target, int total, int[] nums) {
        if(total == target) {
            result.add(new ArrayList(current));
            return;
        }

        if(i >= nums.length || total > target) {
            return;
        }

        current.add(nums[i]);
        dfs(i, target, total + nums[i], nums);

        current.removeLast();
        dfs(i+1, target, total, nums);
    }
}
