class Solution {
    public boolean hasDuplicate(int[] nums) {
        var set = new HashSet<Integer>();
        for (int i : nums) {
            set.add(i);
        }

        return nums.length != set.size();
    }
}