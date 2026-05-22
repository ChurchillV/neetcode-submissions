class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> current = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(0, nums, 0, target);
        return result;
    }

    public void dfs(int i, int[] nums, int total, int target) {
        
        if(total == target) {
            result.add(new ArrayList<>(current));
            return;
        }

        if(i >= nums.length || total > target) {
            return;
        }

        current.add(nums[i]);
        dfs(i, nums, total + nums[i], target);

        current.removeLast();
        dfs(i+1, nums, total, target);
    }
}
