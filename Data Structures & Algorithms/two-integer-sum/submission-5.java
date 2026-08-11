class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length < 2)return new int[]{};

        var numsMap = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            var currentValue = nums[i];
            var matchingValue = numsMap.get(target - currentValue);
            if(matchingValue != null){
                return new int[]{matchingValue, i};
            }

            numsMap.put(currentValue, i);
        }

        return new int[]{};
    }
}
