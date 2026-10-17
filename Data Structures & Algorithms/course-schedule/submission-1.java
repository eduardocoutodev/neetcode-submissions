class Solution {
    private Map<Integer, List<Integer>> adjencyMap = new HashMap<>();
    private Set<Integer> visited = new HashSet<>(); 

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Get adjency map
        for(int i = 0; i < numCourses; i++){
            adjencyMap.put(i, new ArrayList<>());
        }

        for(int[] preReq: prerequisites){
            adjencyMap.get(preReq[0]).add(preReq[1]);
        }

        for(int c=0; c < numCourses; c ++){
            if(!dfsCycleDetected(c)){
                return false;
            }
        }

        return true;
    }

    private boolean dfsCycleDetected(int course){
        // base case
        if(visited.contains(course)){
            return false;
        }

        List<Integer> preReqs = adjencyMap.get(course);
        if(preReqs.isEmpty()){
            return true;
        }

        visited.add(course);
        for(int pre: preReqs){
            if(!dfsCycleDetected(pre)){
                return false;
            }
        }

        visited.remove(course);
        // Since we already verified that no cycle happens for int course, then we can clear its dependecies, so we can quickly go to preReqs.isEmpty() -> returns true
        adjencyMap.put(course, new ArrayList<>());
        return true;
    }
}
