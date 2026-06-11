class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            map1.put((char) (i + 97), 0);
            map2.put((char) (i + 97), 0);
        }

        for (int i = 0; i < s1.length(); i++) {
            map1.compute(s1.charAt(i), (k, v) -> v + 1);
        }

        int l = 0;
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
