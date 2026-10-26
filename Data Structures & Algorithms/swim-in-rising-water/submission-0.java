class Solution {
    record Point(int row, int column, int maxHeight){}
    record Coordinate(int row, int column){}

    List<Coordinate> directions = List.of(
        new Coordinate(1, 0),
        new Coordinate(-1, 0),
        new Coordinate(0, -1),
        new Coordinate(0, 1)
    );

    public int swimInWater(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        PriorityQueue<Point> pq = new PriorityQueue<>(
            Comparator.comparingInt(Point::maxHeight)
        );

        pq.offer(new Point(0, 0, grid[0][0]));

        Set<Coordinate> visited = new HashSet<>();

        while(!pq.isEmpty()){
            Point point = pq.poll();
            if(point.row == rows - 1 && point.column == cols - 1){
                return point.maxHeight;
            }

            if(visited.contains(new Coordinate(point.row, point.column))){
                continue;
            }

            visited.add(new Coordinate(point.row, point.column));

            for(Coordinate coordinate: directions){
                int newRow = point.row + coordinate.row;
                int newCol = point.column + coordinate.column;
                if(Math.min(newRow, newCol) < 0 || newRow >= rows || newCol >= cols) continue;
                int height = Math.max(grid[newRow][newCol], point.maxHeight);

                pq.offer(new Point(newRow, newCol, height));
            }
        }

        return -1;
    }
}
