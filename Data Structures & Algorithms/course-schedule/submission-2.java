class Solution {
    private Map<Integer, List<Integer>> preMap = new HashMap(); // course, prereq
    private Set<Integer> visiting = new HashSet();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for(int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList());
        }

        for(int[] prereq : prerequisites) {
            preMap.get(prereq[0]).add(prereq[1]);
        }

        for(int c = 0; c < numCourses; c++) {
            if(!dfs(c)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int course) {
        if(visiting.contains(course)) {
            return false;
        }

        if(preMap.get(course).isEmpty()) {
            return true;
        }

        visiting.add(course);
        for(int pre : preMap.get(course)) {
            if(!dfs(pre)) {
                return false;
            }
        }

        visiting.remove(course);
        preMap.put(course, new ArrayList());
        return true;
    }
}
