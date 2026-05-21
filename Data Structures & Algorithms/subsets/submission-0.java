class Solution {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();

    public void dfs(int i, int[] nums) {
        if(i >= nums.length) {
            result.add(new ArrayList<>(subset));
            // System.out.println("Subset added: " + subset);
            return;
        }

        // System.out.println("Out of the first if statement");
        // System.out.println("Current value: " + nums[i]);

        subset.add(nums[i]);
        // System.out.println("Subset (With value): " + subset);
        dfs(i+1, nums);


        subset.removeLast();
        // System.out.println("Subset (Without value): " + subset);
        dfs(i+1, nums);
    }

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return result;
    }
}
