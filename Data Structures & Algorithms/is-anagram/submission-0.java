class Solution {
    public boolean isAnagram(String s, String t) {
        var chars = s.toCharArray();
        Arrays.sort(chars);

        var charsSecond = t.toCharArray();
        Arrays.sort(charsSecond);

        return Arrays.equals(chars, charsSecond);
    }
}
