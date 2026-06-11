
class PrefixTree {

    PrefixTreeNode root;

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
            this.children = new PrefixTreeNode[26];
        }
    }

    public void insert(String word) {
        PrefixTreeNode current = root;
        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new PrefixTreeNode(c);
            }
            current = current.children[c - 'a'];
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        PrefixTreeNode target = getLast(word);
        return (target != null && target.isWord);
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
        PrefixTreeNode target = getLast(prefix);
        return target != null;
    }
}