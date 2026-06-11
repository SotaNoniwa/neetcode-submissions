class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>(); // int[] = idx, temperature

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && stack.peek()[1] < temperatures[i]) {
                int prevIdx = stack.pop()[0];
                result[prevIdx] = i - prevIdx;
            }

            stack.push(new int[] { i, temperatures[i] });
        }

        return result;
    }
}
