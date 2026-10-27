class Solution {
    List<Integer> result;

    Set<Integer> visited = new HashSet<>();
    Map<Integer, List<Integer>> adjencyList = new HashMap<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        result = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            adjencyList.put(i, new ArrayList<>());
        }

        for(int[] preRequisite: prerequisites){
            int src = preRequisite[0];
            int dest = preRequisite[1];
            adjencyList.get(src).add(dest);
        }

        for(int i = 0; i < numCourses; i++){
            if(!dfs(i, new HashSet<>())){
                return new int[]{};
            }
        }


        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }

    private boolean dfs(int index, Set<Integer> path){
        if(path.contains(index)) {
            return false;
        }

        if(visited.contains(index)){
            return true;
        }

        visited.add(index);
        path.add(index);

        List<Integer> adjencies = adjencyList.get(index);
        for(Integer adjency: adjencies){
            if(!dfs(adjency, path)){
                return false;
            }
        }

        result.add(index);
        path.remove(index);

        return true;
    }
}
