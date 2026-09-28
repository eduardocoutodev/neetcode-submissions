class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minimalLength = Integer.MAX_VALUE;

        int left = 0;
        int right = 0;
        int sum = 0;

        while(right < nums.length){
            sum += nums[right];

            while(sum >= target){
                minimalLength = Math.min(right - left + 1, minimalLength);
                sum -= nums[left];
                left++;
            }

            right++;
        }


        if(minimalLength == Integer.MAX_VALUE) return 0;
        return minimalLength;
    }
}