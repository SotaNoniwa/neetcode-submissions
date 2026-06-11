class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();

        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (stack.empty()) {
                    stack.push(s.charAt(i));
                } else if (!stack.pop().equals(map.get(s.charAt(i)))) {
                    return false;
                }
                // if (!stack.empty() && !stack.pop().equals(map.get(s.charAt(i)))) {
                // return false;
                // }
            } else {
                stack.push(s.charAt(i));
            }
        }

        System.out.println(stack);
        return stack.empty();
    }
}
