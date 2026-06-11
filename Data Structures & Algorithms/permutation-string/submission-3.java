class Solution {
    // overall time complexity O(n + m)
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        // O(1)
        for (int i = 0; i < 26; i++) {
            // +97 for ASCII value
            map1.put((char) (i + 97), 0);
            map2.put((char) (i + 97), 0);
        }

        // O(n) where n is the length of s1
        for (int i = 0; i < s1.length(); i++) {
            map1.compute(s1.charAt(i), (k, v) -> v + 1);
        }

        int l = 0;
        // O(m) where m is the length of s2
        for (int r = 0; r < s2.length(); r++) {
            map2.compute(s2.charAt(r), (k, v) -> v + 1);

            // window size = r - l + 1
            if (r - l + 1 < s1.length())
                continue;

            if (map1.equals(map2))
                return true;

            map2.compute(s2.charAt(l), (k, v) -> v - 1);
            l++;
        }

        return false;
    }
}
