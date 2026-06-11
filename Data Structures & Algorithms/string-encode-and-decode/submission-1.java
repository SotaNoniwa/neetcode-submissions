class Solution {

    public String encode(List<String> strs) {
        String encoded = "";
        for (String s : strs) {
            encoded += s;
            encoded += ";";
        }
        return encoded;
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        String word = "";
        char[] charArr = str.toCharArray();
        for (char c : charArr) {
            if (c == ';') {
                decoded.add(word);
                word = "";
            } else {
                word += c;
            }
        }
        return decoded;
    }
}
