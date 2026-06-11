class Solution {
    // Brute-force approach: O(n^2) run time
    public int maxArea(int[] heights) {
        int maxAmount = 0;

        for (int left = 0; left < heights.length - 1; left++) {
            for (int right = left + 1; right < heights.length; right++) {
                int len = right - left;
                int amount = Math.min(heights[left], heights[right]) * len;
                maxAmount = Math.max(maxAmount, amount);
            }
        }
        return maxAmount;
    }
}
