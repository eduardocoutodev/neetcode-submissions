class Solution {
    private static Set<Character> validClosingCharacters = Set.of(')', '}', ']');
    private static Map<Character, Character> validCharacters = Map.of(
        '(',')',
        '{', '}',
        '[', ']'
    );

    public boolean isValid(String s) {
        if(s.isEmpty()) return false;
        if(s.length() % 2 != 0)return false;

        var stack = new ArrayDeque<Character>();
        for(var character: s.toCharArray()){
            if(!validClosingCharacters.contains(character)){
                stack.push(character);
            } else {
                if(stack.isEmpty()) return false;
                var matchingOpeningCharacter = stack.pop();
                var validMatchingClosingCharacter = validCharacters.get(matchingOpeningCharacter);
                if(validMatchingClosingCharacter == null || !validMatchingClosingCharacter.equals(character)){
                    return false;
                }

            }
        }

        return stack.isEmpty();
    }
}
