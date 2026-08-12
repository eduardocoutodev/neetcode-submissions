class Solution {
    public int longestConsecutive(int[] nums) {
        
        var mp = new HashMap<Integer, Integer>();

        var maxConsecutive = 0;
        for(var num: nums){
            // Skip duplicates
            if(mp.containsKey(num)) continue;

            mp.put(num, mp.getOrDefault(num - 1, 0) + mp.getOrDefault(num + 1, 0) + 1);
            mp.put(num - mp.getOrDefault(num - 1, 0), mp.get(num));
            mp.put(num + mp.getOrDefault(num + 1, 0), mp.get(num));

            maxConsecutive = Math.max(maxConsecutive, mp.get(num));
        }        

        return maxConsecutive;
    }
}
