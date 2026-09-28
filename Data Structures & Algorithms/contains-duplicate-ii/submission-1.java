class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k <= 0){
            return false;
        }
        int left = 0;
        Set<Integer> set = new HashSet<Integer>();

        for(int right=0; right < nums.length; right++){
            if(right - left > k){
                set.remove(nums[left]);
                left++;
            }

            if(set.contains(nums[right])){
                return true;
            }

            set.add(nums[right]);
        }
        
        return false;
    }
}