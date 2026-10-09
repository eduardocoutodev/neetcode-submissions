class Solution {
    private static final Map<Character, List<Character>> digitsMap = Map.of(
        '2', List.of('a', 'b', 'c'),
        '3', List.of('d', 'e', 'f'),
        '4', List.of('g', 'h', 'i'),
        '5', List.of('j', 'k', 'l'),
        '6', List.of('m', 'n', 'o'),
        '7', List.of('p', 'q', 'r', 's'),
        '8', List.of('t', 'u', 'v'),
        '9', List.of('w', 'x', 'y', 'z')
    );

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.isBlank()) return List.of();
        iterateLetterCombinations(0, result, "", digits);    

        return result;
    }

    private void iterateLetterCombinations(int index, List<String> results, String currentIteraction, String digits){
        if(currentIteraction.length() == digits.length()){
            results.add(new String(currentIteraction));
            return;
        }
        List<Character> characters = digitsMap.get(digits.charAt(index));
        for(Character c: characters){
            iterateLetterCombinations(index + 1, results, currentIteraction + c, digits);
        }
    }
}
