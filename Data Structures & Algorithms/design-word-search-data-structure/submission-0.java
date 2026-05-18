class Node {
    HashMap<Character, Node> children = new HashMap<>();
    boolean endOfWord = false;
}

class WordDictionary {

    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node current = root;

        for(Character c : word.toCharArray()) {
            current.children.putIfAbsent(c, new Node());
            current = current.children.get(c);
        }

        current.endOfWord = true;
    }

    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int index, Node current) {
        if(index == word.length()) {
            return current.endOfWord;
        }

        Character c = word.charAt(index);

        if(c != '.') {
            if(!current.children.containsKey(c)) {
                return false;
            }

            return searchHelper(word, index+1, current.children.get(c));
        } else {
            for(Node child : current.children.values()) {
                if(searchHelper(word, index+1, child)) {
                    return true;
                }
            }
            return false;
        }
    }
}
