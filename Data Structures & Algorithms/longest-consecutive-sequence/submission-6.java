class Solution {
    public int longestConsecutive(int[] nums) {
        var existentNums = new HashSet<Integer>();
        for (var num : nums) {
            existentNums.add(num);
        }

        // then iterate a second time, and do two
        int maxConsecuctive = 0;
        for (var num : nums) {
            if (!existentNums.contains(num - 1)) {
                int i = 1;
                int numToSearch = num + 1;
                while (existentNums.contains(numToSearch)) {
                    numToSearch++;
                    i++;
                }

                maxConsecuctive = Math.max(i, maxConsecuctive);
            }
        }

        return maxConsecuctive;
    }
}
