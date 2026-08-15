class Solution {
    public int longestConsecutive(int[] nums) {
        
        var maxConsecutive = 0;
        var mp = new HashMap<Integer, Integer>();
        for(var i = 0; i < nums.length; i++){
            if(mp.containsKey(nums[i])) continue;

            var current = mp.getOrDefault(nums[i], 0);
            var left = mp.getOrDefault(nums[i] - 1, 0);
            var right = mp.getOrDefault(nums[i] + 1, 0);

            var currentChain = left + right + 1;
            mp.put(nums[i], currentChain);
            mp.put(nums[i] - left, currentChain);
            mp.put(nums[i] + right, currentChain);

            maxConsecutive = Math.max(maxConsecutive, currentChain);
        }

        return maxConsecutive;
    }
}
