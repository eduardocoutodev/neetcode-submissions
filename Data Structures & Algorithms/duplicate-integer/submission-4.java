class Solution {
    public boolean hasDuplicate(int[] nums) {
        var hashMap = new HashMap<Integer, Integer>();

        for(int i=0; i<nums.length; i++){
            var currentValue = nums[i];
            if(hashMap.containsKey(currentValue)) return true;
            
            hashMap.put(currentValue, i);
        }

        return false;
    }
}