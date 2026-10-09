class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        iterateCombinations(1, n, k, result, new ArrayList<Integer>());

        return result;
    }

    private void iterateCombinations(int i, int n, int k, List<List<Integer>> result, List<Integer> currentSet){
        if(currentSet.size() >= k){
            result.add(new ArrayList<Integer>(currentSet));
            return;
        }

        if(i > n){
            return;
        }

        for(int j = i; j <= n; j++){
            currentSet.add(j);
            // Approach to use j
            iterateCombinations(j + 1, n, k, result, currentSet);
            currentSet.remove(currentSet.size() - 1);
        }
    }
}