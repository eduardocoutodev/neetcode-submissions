class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var frequency = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++){
            var currentValue = nums[i];
            frequency.computeIfAbsent(currentValue, key -> 0);

            var currentValueFrequency = frequency.get(currentValue);
            frequency.put(currentValue, ++currentValueFrequency);
        }

        int[] sortedKeys = frequency.entrySet().stream()
            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())) // descending
            .limit(k)
            .mapToInt(Map.Entry::getKey)
            .toArray();

        return sortedKeys;
    }
}
