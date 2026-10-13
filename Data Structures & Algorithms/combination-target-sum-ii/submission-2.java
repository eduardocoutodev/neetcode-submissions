class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        iterateCombinations(candidates, target, 0 ,result, new ArrayList<Integer>(), 0);

        return result;
    }

    private void iterateCombinations(int[] candidates, int target, int index , List<List<Integer>> result, List<Integer> cur, int sum){
        if(sum == target){
            result.add(new ArrayList<>(cur));
            return;
        }

        if(sum > target || index >= candidates.length){
            return;
        }

        int currentElement = candidates[index];
        cur.add(currentElement);

        iterateCombinations(candidates, target, index + 1 ,result, cur , sum + currentElement);
        while(index + 1 < candidates.length && candidates[index] == candidates[index + 1]){
            index++;
        }
        cur.remove(cur.size() - 1);
        iterateCombinations(candidates, target, index + 1 ,result, cur , sum);
    }
}
