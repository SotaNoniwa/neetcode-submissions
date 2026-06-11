class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> s1Count = new HashMap<>();
        Map<Character, Integer> s2Count = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            s1Count.put((char) (i + 97), 0);
            s2Count.put((char) (i + 97), 0);
        }

        for (int i = 0; i < s1.length(); i++) {
            s1Count.compute(s1.charAt(i), (k, v) -> v + 1);
        }

        int begin = 0;
        for (int end = 0; end < s2.length(); end++) {
            s2Count.compute(s2.charAt(end), (k, v) -> v + 1);

            // window size = end - begin + 1;
            if (end - begin + 1 < s1.length()) {
                continue;
            }

            if (s1Count.equals(s2Count)) {
                return true;
            }

            s2Count.compute(s2.charAt(begin), (k, v) -> v - 1);
            begin++;
        }

        return false;
    }
}
