class Solution {
   public:
    vector<int> productExceptSelf(vector<int>& nums) {
        vector<int> res;
        int prefix = 1;  // product of all the nums before nums[i]
        res.push_back(prefix);
        for (int i = 0; i < nums.size() - 1; i++) {
            prefix *= nums[i];
            res.push_back(prefix);
        }
        int postfix = 1; // product of all the nums after nums[i]
        for (int i = nums.size() - 1; i > 0; i--) {
            postfix *= nums[i];
            res.at(i - 1) *= postfix;
        }
        return res;
    }
};
