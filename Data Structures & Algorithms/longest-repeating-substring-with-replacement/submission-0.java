class Solution {
    public int characterReplacement(String s, int k) {
        // frequency array to count char on the list

        // count while the calculation is good, otherwise remove
        int [] charFrequency = new int [26];
        int highestSubStringLen = 0;
        int left = 0, right = 0;

        while(right < s.length()){
            char currentChar = s.charAt(right);
            charFrequency[currentChar - 'A']++;
            // AABBB, k = 1
            // (right - left + 1) = len of substring
            while((right - left + 1) - getCountOfMostFrequentChar(charFrequency) > k){
                charFrequency[s.charAt(left) - 'A']--;
                left++;
            }

            highestSubStringLen = Math.max((right - left + 1), highestSubStringLen);
            right++;
        }

        return highestSubStringLen;
    }

    private int getCountOfMostFrequentChar(int [] charFrequency){
        int highestCountOfFrequentChar = 0;
        for(int i= 0; i < 26; i++){
            highestCountOfFrequentChar = Math.max(
                highestCountOfFrequentChar,
                charFrequency[i]
            );
        }

        return highestCountOfFrequentChar;
    }
}
