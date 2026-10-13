class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        permutations.add(new ArrayList<>());

        for(int num: nums){
            List<List<Integer>> newPermutations = new ArrayList<>();
            for(List<Integer> permutation: permutations){
                for(int i=0; i < permutation.size() + 1; i++){
                    List<Integer> cur = new ArrayList<>(permutation);
                    cur.add(i, num);
                    newPermutations.add(cur);
                }
            }

            permutations = newPermutations;
        }

        return permutations;
    }

}
