class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>(); // pair: index, height
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int startIndex = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] top = stack.pop();
                int index = top[0], height = top[1];
                int area = (i - index) * height;
                maxArea = Math.max(area, maxArea);
                startIndex = index; // can be extended backwords
            }
            stack.push(new int[] { startIndex, heights[i] });
        }

        for (int[] top : stack) {
            int index = top[0], height = top[1];
            int area = (heights.length - index) * height;
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}
