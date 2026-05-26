class Solution {
    public List<List<Integer>> result = new ArrayList<>();
    public List<Integer> combination = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0);
        return result;
    }

    public void dfs(int[] candidates, int target, int total, int i) {
        if(total == target) {
            result.add(new ArrayList<>(combination));
            return;
        }

        if(i >= candidates.length || total > target) {
            return;
        }

        for(int j = i; j < candidates.length; j++) {
            if(j > i && candidates[j] == candidates[j-1]) {
                continue;
            }

            combination.add(candidates[j]);
            dfs(candidates, target, total+candidates[j], j+1);
            combination.removeLast();
        }
    }
}
