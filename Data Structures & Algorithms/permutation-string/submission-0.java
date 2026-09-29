class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        // Frequency array for permutation
        int [] frequencyArray = new int[26];
        for(int i=0; i < s1.length(); i++){
            frequencyArray[s1.charAt(i) - 'a']++;
        }

        int [] currentWindowFrequency = new int[26];

        int left = 0;
        int right = 0;
        while(right < s2.length()){
            Character currentChar = s2.charAt(right);
            currentWindowFrequency[currentChar - 'a']++;

            while(right - left + 1 > s1.length()){
                Character charToRemove = s2.charAt(left);
                currentWindowFrequency[charToRemove - 'a']--;
                left++;
            }

            if(right - left + 1 == s1.length() && Arrays.equals(frequencyArray, currentWindowFrequency)){
                return true;
            }

            right++;
        }

        return false;
    }
}
