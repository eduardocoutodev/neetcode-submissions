class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        permutations.add(new ArrayList<>());

        for (int n : nums) {
            List<List<Integer>> nextPermutations = new ArrayList<List<Integer>>();

            for (List<Integer> permutation : permutations) {
                for (int i = 0; i < permutation.size() + 1; i++) {
                    List<Integer> cur = new ArrayList<>(permutation);
                    cur.add(i, n);
                    nextPermutations.add(cur);
                }
            }

            permutations = nextPermutations;
        }

        return permutations;
    }
}
