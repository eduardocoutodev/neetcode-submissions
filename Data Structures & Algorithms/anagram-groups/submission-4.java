class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var anagrams = new HashMap<String, List<String>>();


        for(int i=0; i < strs.length; i++){
            var current = strs[i];
            var chars = current.toCharArray();
            Arrays.sort(chars);
            var sorted = new String(chars);

            var list = anagrams.getOrDefault(sorted, new ArrayList());
            list.add(current);

            anagrams.put(sorted, list);
        }

        return anagrams.values().stream().toList();
    }
}
