class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        
        int left = 0;
        int right = 0;

        while(right < s.length()){
            Character c = s.charAt(right);

            while(set.contains(c)){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(c);
            maxLength = Math.max(maxLength, set.size());

            right++;
        }

        if(maxLength == Integer.MIN_VALUE) return 0;

        return maxLength;
    }
}
