class Solution {
    public int maxArea(int[] heights) {
        if(heights.length < 2) return 0;
        var maxArea = 0;

        var l = 0;
        var r = heights.length - 1;

        while(r > l){
            var height = Math.min(heights[l], heights[r]);
            var width = r - l;
            var area = height * width;

            maxArea = Math.max(area, maxArea);

            // Segredo esta no facto que tenho que mover consoantes as alturas de l ou r
            // Nada mais
            if(heights[r] >= heights[l]){
                l ++;
            }else{
                r--;
            }

        }

        return maxArea;
    }
}
