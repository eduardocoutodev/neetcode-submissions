class Solution {
    private int colorToChange;
    private int newColor;
    private int COLS;
    private int ROWS;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        ROWS = image.length;
        COLS = image[0].length;
        newColor = color;
        colorToChange = image[sr][sc];
        if(colorToChange == color) return image;

        dfsFlood(image, sr, sc);

        return image;
    }

    private void dfsFlood(int[][] image, int sr, int sc) {
        if (Math.min(sr, sc) < 0 || sr >= ROWS || sc >= COLS || image[sr][sc] != colorToChange)
            return;

        image[sr][sc] = newColor;

        dfsFlood(image, sr + 1, sc);
        dfsFlood(image, sr - 1, sc);
        dfsFlood(image, sr, sc + 1);
        dfsFlood(image, sr, sc - 1);
    }
}