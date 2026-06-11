class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> palindromicSubstrs = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), palindromicSubstrs);
        return palindromicSubstrs;
    }

    private void backtrack(
            String s,
            int beginIdx,
            List<String> partitions, // e.g. if "aab", then one possible partitions is ["aa", "b"]
            List<List<String>> palindromicSubstrs) {
        if (beginIdx >= s.length()) {
            palindromicSubstrs.add(new ArrayList<>(partitions));
            return;
        }

        for (int endIdx = beginIdx; endIdx < s.length(); endIdx++) {
            if (isPalindrome(s, beginIdx, endIdx)) {
                partitions.add(s.substring(beginIdx, endIdx + 1));
                backtrack(s, endIdx + 1, partitions, palindromicSubstrs);
                partitions.remove(partitions.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int beginIdx, int endIdx) {
        while (beginIdx < endIdx) {
            if (s.charAt(beginIdx) != s.charAt(endIdx)) {
                return false;
            }
            beginIdx++;
            endIdx--;
        }
        return true;
    }
}
