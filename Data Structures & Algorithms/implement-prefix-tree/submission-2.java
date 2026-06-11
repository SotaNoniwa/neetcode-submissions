
class PrefixTree {

    public PrefixTreeNode root;

    public PrefixTree() {
        root = new PrefixTreeNode('\0');
    }

    class PrefixTreeNode {
        private char value;
        private boolean isWord;
        private PrefixTreeNode[] children;

        public PrefixTreeNode(char value) {
            this.value = value;
            this.isWord = false;
            this.children = new PrefixTreeNode[26]; // 'a' to 'z' = 26 length
        }
    }

    public void insert(String word) {
        PrefixTreeNode current = root;

        for (char c : word.toCharArray()) {
            // if character doen't match, insert
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new PrefixTreeNode(c);
            }
            // Traverse tree while the characters in word match with those in tree
            current = current.children[c - 'a'];
        }
        // Set isWord true if it is last character in word
        current.isWord = true;
    }

    public boolean search(String word) {
        PrefixTreeNode lastChar = getLast(word);
        return (lastChar != null && lastChar.isWord);
    }

    // Helper method
    private PrefixTreeNode getLast(String word) {
        PrefixTreeNode current = root;

        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                return null;
            }
            current = current.children[c - 'a'];
        }
        return current;
    }

    public boolean startsWith(String prefix) {
        PrefixTreeNode current = root;

        for (char c : prefix.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                return false;
            }
            current = current.children[c - 'a'];
        }
        return true;
    }
}
