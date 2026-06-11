class Solution {
    // O(n) run time, O(1) space
    public int trap(int[] height) {
        int totalArea = 0;
        int leftPtr = 0, rightPtr = height.length - 1;
        int leftMax = height[leftPtr], rightMax = height[rightPtr];
        while (leftPtr < rightPtr) {
            if (leftMax < rightMax) {
                leftPtr++;
                leftMax = Math.max(leftMax, height[leftPtr]);
                totalArea += leftMax - height[leftPtr]; // Cannot be negative because of one line above
            } else {
                rightPtr--;
                rightMax = Math.max(rightMax, height[rightPtr]);
                totalArea += rightMax - height[rightPtr];
            }
        }
        return totalArea;
    }
}
