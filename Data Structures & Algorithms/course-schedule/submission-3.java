class Solution {

    private Map<Integer, ArrayList<Integer>> preMap = new HashMap();
    private Set<Integer> visiting = new HashSet();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int course = 0; course < numCourses; course++) {
            preMap.put(course, new ArrayList());
        }    

        for(int[] pre : prerequisites) {
            preMap.get(pre[0]).add(pre[1]);
        }

        for(int course = 0; course < numCourses; course++) {
            if(!dfs(course)) {
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
