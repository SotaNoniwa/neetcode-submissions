class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> charCount = new HashMap<>();

        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            int count = charCount.getOrDefault(c, -1);
            if (count == 1) {
                charCount.remove(c);
            } else if (count > 1) {
                charCount.replace(c, count - 1);
            }
        }

        return charCount.isEmpty();
    }
}
