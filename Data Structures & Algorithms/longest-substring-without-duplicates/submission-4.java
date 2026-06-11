class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int begin = 0;
        int maxLen = 0;

        for (int end = 0; end < s.length(); end++) {
            while (set.contains(s.charAt(end))) {
                set.remove(s.charAt(begin));
                begin++;
            }
            int len = end - begin + 1;
            maxLen = Math.max(len, maxLen);
            set.add(s.charAt(end));
        }

        return maxLen;
    }
}
