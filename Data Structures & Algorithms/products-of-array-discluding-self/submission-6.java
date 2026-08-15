class Solution {
    public int[] productExceptSelf(int[] nums) {
        var result = new int[nums.length];
        var prefix = new int[nums.length];
        var suffix = new int[nums.length];

        prefix[0]=1;
        suffix[nums.length - 1]=1;

        // Iterate prefix
        for(int i=1; i < nums.length; i++){
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        // Sufix prefix
        for(int i=nums.length - 2; i >= 0; i--){
            suffix[i]=suffix[i + 1] * nums[i + 1];
        }

        for(int i=0; i < nums.length; i++){
            result[i] = prefix[i] * suffix[i];
        }

        return result;        
    }
}  
