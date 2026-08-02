class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers.length < 2) return new int[]{};

        var result = new int[]{0,0};
        var l = 0;
        var r = numbers.length - 1;

        while(r > l){
            var current = numbers[l] + numbers[r];

            if(current == target){
                result[0] = l + 1;
                result[1] = r + 1;
                break;
            }else if(current > target){
                r--;
            }else{
                l++;
            }

        }

        return result;
    }
}
