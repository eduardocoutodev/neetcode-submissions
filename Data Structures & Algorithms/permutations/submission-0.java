class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return recursivePermutations(nums, 0);   
    }

    private List<List<Integer>> recursivePermutations(int[] nums, int index){
        if(index >= nums.length){
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            result.add(new ArrayList<>());
            return result;
        }

        List<List<Integer>> recursive = recursivePermutations(nums, index + 1);
        List<List<Integer>> result = new ArrayList<>();

        for(List<Integer> permutation: recursive){
            for(int j = 0; j < permutation.size() + 1; j++){
                List<Integer> cur = new ArrayList<>();
                cur.addAll(permutation);

                cur.add(j, nums[index]);
                result.add(cur);
            }
        }

        return result;
    }
}
