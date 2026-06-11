class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for (int n : nums) {
            numSet.add(n);
        }

        int maxLen = 0;
        for (int n : nums) {
            // Check if n is first num of consective sequence
            if (!numSet.contains(n - 1)) {
                int len = 1;
                while (numSet.contains(n + len)) {
                    len++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }
}
