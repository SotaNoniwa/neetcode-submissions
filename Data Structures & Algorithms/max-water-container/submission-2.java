class Solution {
    // Optimized approach: O(n) run time
    public int maxArea(int[] heights) {
        int maxAmount = 0;
        int left = 0, right = heights.length - 1;
        while (left < right) {
            int len = right - left;
            int amount = Math.min(heights[left], heights[right]) * len;
            maxAmount = Math.max(amount, maxAmount);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxAmount;
    }
}
