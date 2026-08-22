class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i < nums.length - 2 && nums[i] <= 0 ; i++){
            // Skip duplicates
            if(i > 0 && nums[i] == nums[i-1]) continue;
            var l = i + 1;
            var r = nums.length - 1;
            while(r > l){
                var sum = nums[i] + nums[l] + nums[r];
                
                if(sum == 0){
                    res.add(List.of(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    while (l < r && nums[r] == nums[r+1]) r--;

                    continue;
                }

                if(sum > 0){
                    // R is too big, move r to left
                    r--;
                }else {
                    // L is too small, move l to the right
                    l++;
                }
            }
        }

        return res;
    }
}
