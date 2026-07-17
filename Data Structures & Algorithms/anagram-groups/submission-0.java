class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var mapByAnagram = new HashMap<String, List<String>>(strs.length);
    for(var originalValue: strs){
        var chars = originalValue.toCharArray();
        Arrays.sort(chars);

        var sortedKey = new String(chars);

        var existingAnagrams = mapByAnagram.get(sortedKey);
        if(existingAnagrams == null){
            existingAnagrams = new ArrayList<>();
        }
        existingAnagrams.add(originalValue);
        
        mapByAnagram.put(sortedKey, existingAnagrams);
    }

    return mapByAnagram.values().stream()
            .toList();
    }
}
