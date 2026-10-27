class Solution {
    private Map<Integer, List<Integer>> adjencyMap = new HashMap<>();
    private Set<Integer> visited = new HashSet<>(); 

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Get adjency map
        for(int i = 0; i < numCourses; i++){
            adjencyMap.put(i, new ArrayList<>());
        }

        for(int[] prerequisite: prerequisites){
            int src = prerequisite[0];
            int dest = prerequisite[1];
            adjencyMap.get(src).add(dest);
        }

        for(int i = 0; i < numCourses; i++){
            if(!dfs(i, new ArrayList<>())){
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int i, List<Integer> path){
        if(path.contains(i)) return false;

        if(visited.contains(i)) return true;

        visited.add(i);
        path.add(i);

        List<Integer> adjencies = adjencyMap.get(i);
        for(Integer adjency: adjencies){
            if(!dfs(adjency, path)){
                return false;
            }
        }

        path.remove(path.size() - 1);

        return true;
    }
}
