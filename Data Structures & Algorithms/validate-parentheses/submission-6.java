class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> brackets = new HashMap<>();
        Stack<Character> stack = new Stack<>();

        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (!stack.isEmpty() && brackets.containsKey(curr)) {
                char prev = stack.pop();
                if (prev != brackets.get(curr)) {
                    return false;
                }
            } else {
                stack.push(curr);
            }
        }

        return stack.isEmpty();
    }
}
