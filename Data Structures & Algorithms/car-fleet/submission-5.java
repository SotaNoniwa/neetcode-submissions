class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stack = new Stack<>();

        int n = position.length;
        double[][] pairs = new double[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }
        // sort array based on their position in descending order
        Arrays.sort(pairs, (x, y) -> Double.compare(y[0], x[0]));

        for (int i = 0; i < n; i++) {
            double carPosition = pairs[i][0];
            double carSpeed = pairs[i][1];
            double timeToReach = (target - carPosition) / carSpeed;

            if (stack.isEmpty() || timeToReach > stack.peek()) {
                stack.push(timeToReach);
            }
        }

        return stack.size();
    }
}
