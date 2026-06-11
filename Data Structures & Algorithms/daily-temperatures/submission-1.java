class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[temperatures.length]; // pair: [temp, index]

        for (int i = 0; i < temperatures.length; i++) {
            int currentTemp = temperatures[i];

            while (!stack.isEmpty() && stack.peek()[0] < currentTemp) {
                int[] pair = stack.pop();
                int index = pair[1];
                res[index] = i - index;
            }

            stack.push(new int[] { currentTemp, i });
        }
        return res;
    }
}
