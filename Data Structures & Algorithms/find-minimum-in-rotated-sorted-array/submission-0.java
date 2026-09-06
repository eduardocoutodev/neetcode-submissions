class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int min = nums[0];

        while(right > left){
            var mid = left + (right - left) / 2;
            if(nums[mid] < nums[right]){
                // mid can be final result
                right = mid;
            }else {
                // mid + 1 because mid we already know cant be the final solution since right has higher value than mid
                left = mid + 1;
            }

        }
        
        return nums[left];
    }
}
