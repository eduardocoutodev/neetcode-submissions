class Solution {
    public int maxArea(int[] heights) {
        if(heights.length < 2) return 0;
        var maxArea = 0;

        var l = 0;
        var r = heights.length - 1;

        while(r > l){
            var left = heights[l];
            var right = heights[r];

            var width = r - l;
            var minHeight = Math.min(left, right);
            var area = minHeight * width;

            maxArea = Math.max(maxArea, area);

            if(right > left){
                l++;
            }else {
                r--;
            }
        }
            
        return maxArea;
    }
}
