class Solution {
    public boolean isPalindrome(String s) {
        // If is even, then no issue
        // If its uneven then ignore the middle char
        if(s == null || s.isBlank()){
            return true;
        }
        
        var processedS = s.trim().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if(processedS.length() <= 0){
            return true;
        }
        
        var l = 0;
        var r = processedS.length() - 1;

        for(var i = 0; i < s.length()/2; i ++){
            var leftChar = processedS.charAt(l);
            var rightChar = processedS.charAt(r);
            
            if(leftChar != rightChar){
                return false;
            }
            
            l++;
            r--;
        }
        
        return true;
    }
}
