class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length < 2)return new int[]{};

        for(var i = 0; i <nums.length; i++){
            for(var j=0; j<nums.length; j++){
                if(i == j) continue;

                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }

        return new int[]{};
    }
}
