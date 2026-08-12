class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var frequency = new HashMap<Integer, Integer>();

        for(var i = 0; i < nums.length; i++){
            var value = nums[i];
            var frequencyValue = frequency.getOrDefault(value, 0);
            
            frequency.put(value, ++frequencyValue);
        }

        // Index means the frequency, if index is 88, then the values inside of it have 88 frequencies
        var lookupFrequency = new ArrayList<ArrayList<Integer>>(nums.length);
        for(int i=0; i<nums.length; i++){
            lookupFrequency.add(i, new ArrayList<Integer>());
        }

        for(var e: frequency.entrySet()){
            var value = e.getKey();
            var frequencyValue = e.getValue();

            var existentValues = lookupFrequency.get(frequencyValue - 1).add(value);
        }

        var response = new int[k];
        int existentK = 0;
        for (int index=lookupFrequency.size() - 1; index >= 0 && existentK < k; index--){
            var existentValues = lookupFrequency.get(index);
            if(existentValues == null || existentValues.isEmpty()) continue;

            for(var value: existentValues){
                response[existentK]=value;
                existentK++;
                if(existentK >= k) break;
            }
        }
        
        return response;
    }
}
