class Solution {
    // different approach, it may not be straight forward
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();

        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (stack.empty()) {
                    // this push makes stack non-empty if it is invalid
                    stack.push(s.charAt(i));
                } else if (!stack.pop().equals(map.get(s.charAt(i)))) {
                    return false;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }

        return stack.empty();
    }
}
