class WordDictionary {
    private static final char WILDCARD_CHAR = '.';

    WordDictionaryNode root;

    class WordDictionaryNode {
        Map<Character, WordDictionaryNode> children;
        boolean isLeaf;

        WordDictionaryNode() {
            children = new HashMap<>();
            isLeaf = false;
        }
    }

    public WordDictionary() {
        root = new WordDictionaryNode();
    }

    public void addWord(String word) {
        WordDictionaryNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!current.children.containsKey(c)) {
                current.children.put(c, new WordDictionaryNode());
            }
            current = current.children.get(c);
        }
        current.isLeaf = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int currentIndex, WordDictionaryNode currentNode) {
        WordDictionaryNode current = currentNode;

        for (int i = currentIndex; i < word.length(); i++) {
            char c = word.charAt(i);

            if (c == WILDCARD_CHAR) {
                for(char childrenChar: current.children.keySet()){
                    if(dfs(word, i + 1, current.children.get(childrenChar))){
                        return true;
                    }
                }
                return false;
            } else {
                if (!current.children.containsKey(c)) {
                    return false;
                }
                current = current.children.get(c);
            }
        }

        return current.isLeaf;
    }
}
