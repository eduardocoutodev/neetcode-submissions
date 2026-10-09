class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultSet = new ArrayList<>();
        List<Integer> curSet = new ArrayList<>();

        exploreSubsets(nums, 0, resultSet, curSet);

        return resultSet;
    }

    private void exploreSubsets(int[] nums, int index, List<List<Integer>> resultSet, List<Integer> curSet) {
        if(index >= nums.length){
            resultSet.add(new ArrayList(curSet));
            return;
        }
        curSet.add(nums[index]);
        exploreSubsets(nums, index + 1, resultSet, curSet);
        curSet.remove(curSet.size() - 1);

        while(index + 1 < nums.length && nums[index] == nums[index + 1]){
            index++;
        }

        exploreSubsets(nums, index + 1, resultSet, curSet);
    }
}
