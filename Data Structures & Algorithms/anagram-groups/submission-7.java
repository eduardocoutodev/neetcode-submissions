class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var anagrams = new HashMap<Integer, List<String>>();

        for(var i = 0; i < strs.length; i++){
            var currentValue = strs[i];

            var charArray = new int[26];
            for(var x : currentValue.toCharArray()){
                var currentFrequency = charArray[x - 'a'];
                charArray[x - 'a']=++currentFrequency;
            }

            var hash = Arrays.hashCode(charArray);
            anagrams.computeIfAbsent(hash, key -> new ArrayList<String>()).add(currentValue);
        }

        return anagrams.values().stream().toList();    
    }
}
