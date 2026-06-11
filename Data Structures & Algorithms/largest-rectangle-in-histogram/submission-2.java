class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>(); // pair = index, height
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int startIdx = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int prevIdx = stack.peek()[0];
                int prevHeight = stack.pop()[1];
                int area = (i - prevIdx) * prevHeight;
                maxArea = Math.max(maxArea, area);
                startIdx = prevIdx;
            }
            stack.push(new int[] { startIdx, heights[i] });
        }

        // When we reach at the end of array, calculate rest of area stored in stack
        for (int[] pair : stack) {
            int index = pair[0];
            int height = pair[1];
            int area = (heights.length - index) * height;
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}
