class Solution {
   public:
    int evalRPN(vector<string>& tokens) {
        unordered_set<string> operations = {"-", "+", "*", "/"};
        stack<int> nums;
        for (const string& s : tokens) {
            if (operations.contains(s)) {
                int second = nums.top();
                nums.pop();
                int first = nums.top();
                nums.pop();
                int res;
                if (s == "-") {
                    res = first - second;
                } else if (s == "+") {
                    res = first + second;
                } else if (s == "*") {
                    res = first * second;
                } else {
                    res = first / second;
                }
                nums.push(res);
            } else {
                nums.push(stod(s));
            }
        }
        return nums.top();
    }
};
