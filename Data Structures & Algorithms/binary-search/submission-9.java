class Solution {
    public int search(int[] nums, int target) {
        int result = -1;
        int l = 0;
        int r = nums.length - 1;
        // 1 2 3 4 5 6
        // target 2
        // 6 / 2 = 3 -> value 4
        // 
       
        while(l <= r){
            int pointer = l + (r - l) / 2;

            var currentValue = nums[pointer];
            if(currentValue == target) return pointer;

            if(currentValue > target){
                r = pointer - 1;
            }else {
                l = pointer + 1;
            }
        }

        
        return -1;
    }
}
