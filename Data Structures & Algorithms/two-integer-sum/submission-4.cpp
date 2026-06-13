class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> idx_memo;
        for (int i = 0; i < nums.size(); i++) {
            int complement = target - nums[i];
            if (idx_memo.count(nums[i])) {
                return {idx_memo[nums[i]], i};
            }
            idx_memo[complement] = i;
        }
        return {};
    }
};
