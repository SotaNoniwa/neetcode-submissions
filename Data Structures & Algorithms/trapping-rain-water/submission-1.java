class Solution {
    // O(n) run time, O(n) space
    public int trap(int[] height) {
        int[] maxLeftList = new int[height.length];
        int currentMaxLeft = 0;
        for (int i = 0; i < height.length; i++) {
            currentMaxLeft = Math.max(currentMaxLeft, height[i]);
            maxLeftList[i] = currentMaxLeft;
        }

        int[] maxRightList = new int[height.length];
        int currentMaxRight = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            currentMaxRight = Math.max(currentMaxRight, height[i]);
            maxRightList[i] = currentMaxRight;
        }

        int totalArea = 0;
        for (int i = 0; i < height.length; i++) {
            int minHeight = Math.min(maxLeftList[i], maxRightList[i]);
            int area = minHeight - height[i];
            if (area > 0) {
                totalArea += area;
            }
        }

        return totalArea;
    }
}
