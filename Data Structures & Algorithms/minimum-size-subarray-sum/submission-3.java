class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int minimalLength = Integer.MAX_VALUE;

        List<Integer> slidingWindow = new ArrayList<Integer>();
        int right = 0;

        while(right < nums.length){
            slidingWindow.add(nums[right]);

            while(isSlidingWindowSumBiggerOrEqualThanTarget(slidingWindow, target)){
                minimalLength = Math.min(minimalLength, slidingWindow.size());
                slidingWindow.remove(0);
            }

            right++;
        }


        if(minimalLength == Integer.MAX_VALUE) return 0;
        return minimalLength;
    }

    private boolean isSlidingWindowSumBiggerOrEqualThanTarget(List<Integer> slidingWindow, int target){
        int sum = 0;
        for(int num: slidingWindow){
            sum+=num;
        }
        return sum >= target;
    }
}