class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // while r > l && numbers[r] != numbers[l]
        var l = 0; 
        var r = numbers.length - 1;

        while(r > l){
            var sum = numbers[l] + numbers[r];

            if(sum == target){
                return new int[]{l + 1, r + 1};
            }

            if(sum > target){
                r--;
            }else{
                l++;
            }
        }

        return new int[]{};
    }
}
