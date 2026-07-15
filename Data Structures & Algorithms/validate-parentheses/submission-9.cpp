class Solution {
   public:
    bool isValid(string s) {
        if (s.length() < 2) return false;

        stack<char> left;
        for (const char& c : s) {
            if (!left.empty() && c == ')') {
                if (left.top() != '(') return false;
                left.pop();
            } else if (!left.empty() && c == '}') {
                if (left.top() != '{') return false;
                left.pop();
            } else if (!left.empty() && c == ']') {
                if (left.top() != '[') return false;
                left.pop();
            } else {
                left.push(c);
            }
        }
        return left.empty();
    }
};
