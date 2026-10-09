class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        iterateCombinationSum(nums, target, 0, result, new ArrayList<Integer>(), 0);

        return result;
    }

    private void iterateCombinationSum(int[] nums, int target, int index ,List<List<Integer>> result, List<Integer> currentSet, int currentSum){
        if(currentSum == target){
            result.add(new ArrayList<>(currentSet));
            return;
        }

        for(int j = index; j < nums.length; j++){
            if(currentSum + nums[j] > target){
                return;
            }
            currentSet.add(nums[j]);
            iterateCombinationSum(nums, target, j, result, currentSet, currentSum + nums[j]);
            currentSet.remove(currentSet.size() - 1);
        }
    }
}
