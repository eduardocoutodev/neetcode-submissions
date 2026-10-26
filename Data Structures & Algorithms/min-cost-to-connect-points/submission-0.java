class Solution {
    record Coordinate(int row, int col, int weight){}
    record Point(int row, int col){}

    public int minCostConnectPoints(int[][] points) {
        // adjency with weights
        // MinHeap
        // List<Coordinate>
        Map<Point, List<Coordinate>> adjencyMap = new HashMap<>();
        for(int[] point: points){
            adjencyMap.put(new Point(point[0], point[1]), new ArrayList<>());
        }

        for(int i = 0; i < points.length - 1; i++){
            for(int j = i + 1; j < points.length; j++){
                int[] pointI = points[i];
                int[] pointJ = points[j];

                int distance = manhatttanDistance(pointI, pointJ);

                adjencyMap.get(new Point(pointI[0],pointI[1]))
                    .add(new Coordinate(pointJ[0], pointJ[1], distance));

                adjencyMap.get(new Point(pointJ[0],pointJ[1]))
                    .add(new Coordinate(pointI[0], pointI[1], distance));

            }
        }

        Set<Point> visited = new HashSet<>();
        PriorityQueue<Coordinate> pq = new PriorityQueue(
            Comparator.comparingInt(Coordinate::weight)
        );
        pq.offer(new Coordinate(points[0][0], points[0][1], 0));

        List<Integer> result = new ArrayList<>();

        while(!pq.isEmpty()){
            Coordinate destination = pq.poll();
            Point currentPoint = new Point(destination.row, destination.col);

            if(result.size() == points.length){
                break;
            }

            if(visited.contains(currentPoint)) continue;
            visited.add(currentPoint);
            result.add(destination.weight);

            List<Coordinate> adjencies = adjencyMap.get(currentPoint);
            for(Coordinate adjency: adjencies){
                if(visited.contains(new Point(adjency.row, adjency.col))) continue;

                pq.offer(new Coordinate(adjency.row, adjency.col, adjency.weight));
            }
        }
        
        int sum = 0;
        for(int weight: result){
            sum += weight;
        }

        return sum;
    }

    private int manhatttanDistance(int[] pointI, int[] pointJ){
        return Math.abs(pointI[0] - pointJ[0]) + Math.abs(pointI[1] - pointJ[1]);
    }
}
