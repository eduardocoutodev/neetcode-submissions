class PrefixTree {
    PrefixTreeNode root;

    class PrefixTreeNode{
        Map<Character, PrefixTreeNode> children;
        boolean isLeaf;

        PrefixTreeNode(){
            children = new HashMap<>();
            isLeaf = false;
        }
    }

    public PrefixTree() {
        root = new PrefixTreeNode();   
    }

    public void insert(String word) {
        PrefixTreeNode current = root;
        
        for(int i=0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!current.children.containsKey(c)){
                current.children.put(c, new PrefixTreeNode());
            }
            current = current.children.get(c);
        }

        current.isLeaf = true;
    }

    public boolean search(String word) {
        PrefixTreeNode current = root;

        for(int i=0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!current.children.containsKey(c)){
                return false;
            }
            current = current.children.get(c);
        }

        return current.isLeaf;
    }

    public boolean startsWith(String prefix) {
        PrefixTreeNode current = root;

        for(int i=0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(!current.children.containsKey(c)){
                return false;
            }
            current = current.children.get(c);
        }

        return true;
    }
}
