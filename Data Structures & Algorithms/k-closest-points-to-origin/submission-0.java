class Solution {
    record EuclideanDistance(int []coordinates, double euclideanDistance){}

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<EuclideanDistance> maxHeap = new PriorityQueue<>(
           Comparator.comparingDouble(EuclideanDistance::euclideanDistance).reversed()
        );

        for(int [] coordinate: points){
            maxHeap.offer(new EuclideanDistance(coordinate, euclideanDistance(coordinate[0], coordinate[1])));
        }

        while(maxHeap.size() > k){
            maxHeap.poll();
        }

        int [][] result = new int[k][2];
        for(int i = 0; i<k; i++){
            result[i] = maxHeap.poll().coordinates();
        }

        return result;
    }

    private double euclideanDistance(int x, int y){
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
}
