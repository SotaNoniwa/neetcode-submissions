class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> allCombos = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        backtrack(n, 0, 0, stack, allCombos);
        return allCombos;
    }

    private void backtrack(int numOfBrackets, int numOfOpenB, int numOfClosedB, Stack<Character> stack,
            List<String> allCombos) {
        if (numOfOpenB == numOfClosedB && numOfOpenB == numOfBrackets) {
            StringBuilder sb = new StringBuilder();
            for (char c : stack) {
                sb.append(c);
            }
            allCombos.add(sb.toString());
            return;
        }

        // We have two branch for each point in backtracking
        // Branch 1: Add open bracket
        if (numOfOpenB < numOfBrackets) {
            stack.push('(');
            backtrack(numOfBrackets, numOfOpenB + 1, numOfClosedB, stack, allCombos);
            stack.pop(); // remove what we push '(' for other branch
        }
        // Branch 2: Add closed bracket
        if (numOfClosedB < numOfOpenB) {
            stack.push(')');
            backtrack(numOfBrackets, numOfOpenB, numOfClosedB + 1, stack, allCombos);
            stack.pop(); // remove ')' for next backtracking
        }
    }
}
