class Solution {
    List<List<Integer>> uniqueCombinations = new ArrayList<>();
    List<Integer> current = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0, candidates, 0, target);
        return uniqueCombinations;
    }

    public void dfs(int i, int[] candidates, int total, int target) {
        if(total == target) {
            uniqueCombinations.add(new ArrayList<>(current));
            return;
        }

        if(total > target || i >= candidates.length) {
            return;
        }

        for(int j = i; j < candidates.length; j++) {

            if(j > i && candidates[j] == candidates[j-1]) {
                continue;
            }

            current.add(candidates[j]);
            dfs(j+1, candidates, total + candidates[j], target);
            current.removeLast();
        }

    }
}
