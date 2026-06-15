class Solution {
   public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> count_map;
        for (const int& num : nums) {
            count_map[num]++;
        }
        vector<vector<int>> freq_count(nums.size());
        for (const pair<const int, int>& kv : count_map) {
            freq_count[kv.second - 1].push_back(kv.first);
        }
        vector<int> res;
        for (int i = freq_count.size() - 1; i >= 0; i--) {
            for (const int& num : freq_count[i]) {
                res.push_back(num);
                k--;
                if (k == 0) return res;
            }
        }
        return {};
    }
};
