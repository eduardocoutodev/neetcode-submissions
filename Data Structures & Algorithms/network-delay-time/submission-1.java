class Solution {
    record Edge(int dest, int weight){}
    public int networkDelayTime(int[][] times, int n, int k) {
        // minHeap para djistra -> MinHeap<Edge>
        // lista<int> -> lista[i - 1] -> peso de ir de k -> i
        Map<Integer, List<Edge>> adjencyMap = new HashMap<>();
        for(int i = 1; i <= n; i++){
            adjencyMap.put(i, new ArrayList<>());
        }

        for(int i = 0; i < times.length; i++){
            int[] time = times[i];

            adjencyMap.get(time[0]).add(new Edge(time[1], time[2]));
        }


        PriorityQueue<Edge> pq = new PriorityQueue<>(
            Comparator.comparingInt(Edge::weight)
        );

        Map<Integer, Integer> solution = new HashMap<>();

        pq.offer(new Edge(k, 0));
        while(!pq.isEmpty()){
            Edge current = pq.poll();
            if(solution.containsKey(current.dest)){
                continue;
            }

            solution.put(current.dest, current.weight);
            List<Edge> adjencies = adjencyMap.get(current.dest);

            for(Edge adjency: adjencies){
                pq.offer(new Edge(adjency.dest, current.weight + adjency.weight));
            }

        }

        for(int i = 1; i <= n; i++){
            if(!solution.containsKey(i)) return -1;
        }

        return Collections.max(solution.values());
    }
}
