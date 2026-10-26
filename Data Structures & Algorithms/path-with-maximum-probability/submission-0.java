class Solution {
    record Edge(int destination, double probability){}
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<Edge>> adjancyMap = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            adjancyMap.put(i, new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            int [] current = edges[i];
            double success = succProb[i];

            adjancyMap.get(current[0]).add(new Edge(current[1], success));
            adjancyMap.get(current[1]).add(new Edge(current[0], success));
        }

        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Edge> pq = new PriorityQueue(
            Comparator.comparingDouble(Edge::probability).reversed()
        );

        pq.offer(new Edge(start_node, 1));

        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            if(visited.contains(edge.destination)) continue;

            if(edge.destination == end_node){
                return edge.probability;
            }

            visited.add(edge.destination);
            List<Edge> adjencyList = adjancyMap.get(edge.destination);

            for(Edge adjency: adjencyList){
                pq.offer(new Edge(adjency.destination, adjency.probability * edge.probability));
            }
        }
        
        return 0;
    }
}