class Solution {
    Map<Integer, List<Integer>> adjencyMap = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    List<Integer> topologicalSort = new ArrayList<>();

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        for(int i = 0; i < numCourses; i++){
            adjencyMap.put(i, new ArrayList<>());
        }

        for(int[] prerequisite: prerequisites){
            int src = prerequisite[0];
            int dest = prerequisite[1];
            adjencyMap.get(src).add(dest);
        }

        List<Boolean> result = new ArrayList<>();
        for(int[] query: queries){
            int preRequisite = query[0];
            int course = query[1];

            
            result.add(reachable(query[0], query[1], new HashSet<>()));
        }

        return result;
    }

    private boolean reachable(int current, int target, Set<Integer> seen){
        if(seen.contains(current)) return false;
        seen.add(current);

        List<Integer> adjencies = adjencyMap.get(current);
        for(Integer adjency: adjencies){
            if(adjency == target || reachable(adjency, target, seen)){
                return true;
            }
        }

        return false;
    }
}