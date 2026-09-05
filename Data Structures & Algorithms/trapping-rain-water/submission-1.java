class Solution {
    public int trap(int[] height) {
        var result = 0;
        // left, beginning of wall
        // right , end of the wall
        var l = 0;
        var leftMax = height[0];
        var r = height.length - 1;
        var rightMax = height[r];

        while(l < r){
            if(leftMax < rightMax){
                l++;
                leftMax=Math.max(leftMax, height[l]);
                result+=leftMax-height[l];
            }else {
                r--;
                rightMax=Math.max(rightMax, height[r]);
                result+=rightMax-height[r];
            }
        }

        return result;
    }
}
