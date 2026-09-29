class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";

        int resultLeft = 0;
        int resultRight = Integer.MAX_VALUE;

        int left = 0;
        int right = 0;

        int [] subStringFrequency = new int[128];
        for(int i=0; i < t.length(); i++){
            subStringFrequency[t.charAt(i)]++;
        }

        int [] currentWindowFrequency = new int[128];
        // se ja estiver a preencher os requisitos
        // faz pop de left e valida
        while(right < s.length()){
            char currentChar = s.charAt(right);
            currentWindowFrequency[currentChar]++;

            while(doesContainSubString(subStringFrequency, currentWindowFrequency)){
                if((right - left) < (resultRight - resultLeft)){
                    resultRight = right;
                    resultLeft = left;
                }
                char charToRemove = s.charAt(left);
                currentWindowFrequency[charToRemove]--;
                left++;
            }

            right++;
        }

        if(resultRight == Integer.MAX_VALUE) return "";
        return s.substring(resultLeft, resultRight + 1);
    }

    private boolean doesContainSubString(int[] subStringFrequency, int [] currentWindowFrequency){
        for(int i = 0; i < 128; i++){
            if(subStringFrequency[i] == 0) continue;

            if(subStringFrequency[i] > currentWindowFrequency[i]) return false; 
        }

        return true;
    }
}
