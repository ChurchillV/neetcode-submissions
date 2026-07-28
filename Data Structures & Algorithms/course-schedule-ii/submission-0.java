class Solution {
    private Map<Integer, ArrayList<Integer>> preMap = new HashMap();
    private Set<Integer> visiting = new HashSet();
    private Set<Integer> visited = new HashSet();
    private List<Integer> order = new ArrayList();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for(int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<Integer>());
        }

        for(int[] pre : prerequisites) {
            preMap.get(pre[0]).add(pre[1]);
        }

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i)) {
                return new int[]{};
            }
        }

        int[] result = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            result[i] = order.get(i);
        } 

        return result;
    }

    private boolean dfs(int course) {
        if(visiting.contains(course)) {
            return false;
        }

        if(visited.contains(course)) {
            return true;
        }

        visiting.add(course);

        for(int pre : preMap.get(course)) {
            if(!dfs(pre)) {
                return false;
            }
        }

        visiting.remove(course);
        visited.add(course);
        preMap.put(course, new ArrayList());
        order.add(course);
        return true;
    }
}
