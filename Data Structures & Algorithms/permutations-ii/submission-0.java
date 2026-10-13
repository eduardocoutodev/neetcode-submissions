class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> permutations = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        List<Integer> curr = new ArrayList<>();

        permuteUniqueRecursevely(nums, permutations, visited, curr);

        return permutations;
    }

    private void permuteUniqueRecursevely(int[] nums, List<List<Integer>> permutations, boolean[] visited, List<Integer> curr){
        if(curr.size() == nums.length){
            permutations.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            // For 1 a and 1b, gives priority to 1a to do all the logic
            if(visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) continue;
            visited[i] = true;
            curr.add(nums[i]);
            permuteUniqueRecursevely(nums, permutations, visited, curr);
            visited[i] = false;
            curr.remove(curr.size() - 1);
        }
    }
}