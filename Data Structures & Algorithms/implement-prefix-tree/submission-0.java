class PrefixNode {
    HashMap<Character, PrefixNode> children = new HashMap<>();
    boolean endOfWord = false;
}

class PrefixTree {

    private PrefixNode root;

    public PrefixTree() {
         root = new PrefixNode();
    }

    public void insert(String word) {
        PrefixNode current = root;

        for(char c : word.toCharArray()) {
            current.children.putIfAbsent(c, new PrefixNode());
            current = current.children.get(c);
        }

        current.endOfWord = true;
    }

    public boolean search(String word) {
        PrefixNode current = root;

        for(char c : word.toCharArray()) {
            if(!current.children.containsKey(c)) {
                return false;
            }

            current = current.children.get(c);
        }

        return current.endOfWord;
    }

    public boolean startsWith(String prefix) {
        PrefixNode current = root;

        for(char c : prefix.toCharArray()) {
            if(!current.children.containsKey(c)) {
                return false;
            }

            current = current.children.get(c);
        }

        return true;
    }
}
