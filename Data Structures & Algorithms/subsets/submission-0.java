class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultSet = new ArrayList<>();
        List<Integer> currentSet = new ArrayList<>();
        iterateSubSet(nums, 0, resultSet, currentSet);
        
        return resultSet;
    }

    private void iterateSubSet(int[] nums, int index, List<List<Integer>> resultSet, List<Integer> currentSet){
        if(index >= nums.length){
            resultSet.add(new ArrayList<>(currentSet));
            return;
        }
        currentSet.add(nums[index]);
        iterateSubSet(nums, index + 1, resultSet, currentSet);
        // Remove last element so it can iterate on subset
        currentSet.remove(currentSet.size() - 1);
        iterateSubSet(nums, index + 1, resultSet, currentSet);
    }
}
