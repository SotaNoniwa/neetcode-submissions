class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");

        for (String s : tokens) {
            if (operators.contains(s)) {
                int r = stack.pop();
                int l = stack.pop();
                stack.push(calculate(l, r, s));
            } else {
                stack.push(Integer.valueOf(s));
            }
            System.out.println("stack: " + stack);
        }
        return stack.peek();
    }

    public int calculate(int x, int y, String operator) {
        return switch (operator) {
            case "+" -> x + y;
            case "-" -> x - y;
            case "*" -> x * y;
            case "/" -> {
                if (y != 0) {
                    yield x / y;
                } else {
                    throw new IllegalArgumentException("Division by zero");
                }
            }
            default -> throw new IllegalArgumentException("Invlid operator: " + operator);
        };
    }
}