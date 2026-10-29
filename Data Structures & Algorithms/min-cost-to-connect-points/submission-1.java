class Solution {
    public class DSU {
        int[] rank;
        int[] parent;

        public DSU(int n){
            rank = new int[n];
            parent = new int[n];

            for(int i = 0; i < n; i++){
                parent[i]=i;
                rank[i]=1;
            }
        }

        int find(int i){
            if(parent[i] != i){
                parent[i] = find(parent[i]);
            }

            return parent[i];
        }

        public boolean union(int i, int j){
            int parentI = find(i);
            int parentJ = find(j);

            if(parentI == parentJ){
                return false;
            }

            if(rank[parentI] >= rank[parentJ]){
                rank[parentI] = rank[parentI] + 1;
                parent[parentJ] = parentI;
            }else {
                rank[parentJ]= rank[parentJ] + 1;
                parent[parentI] = parentJ;
            }

            return true;
        }
    }


    record Coordinate(int src, int dest, int weight){}
    record Point(int row, int col){}

    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Coordinate> pq = new PriorityQueue(
            Comparator.comparingInt(Coordinate::weight)
        );

        for(int i = 0; i < points.length - 1; i++){
            for(int j = i + 1; j < points.length; j++){
                int[] pointI = points[i];
                int[] pointJ = points[j];

                int distance = manhatttanDistance(pointI, pointJ);
                

                pq.offer(new Coordinate(i, j, distance));
            }
        }

        List<Integer> result = new ArrayList<>();
        DSU dsu = new DSU(points.length);
 
        while(result.size() < points.length - 1){
            Coordinate coordinate = pq.poll();
            int src = coordinate.src;
            int dest = coordinate.dest;

            if(!dsu.union(src, dest)){
                continue;
            }
            result.add(coordinate.weight);
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
