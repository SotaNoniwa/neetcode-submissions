class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> res;
        for (const string& s : strs) {
            array<int, 26> count = {};
            for (const char& c : s) {
                count[c - 'a']++;
            }
            string key = to_string(count[0]);
            for (const auto& flag : count) {
                key += ',' + to_string(flag);
            }
            res[key].push_back(s);
        }
        vector<vector<string>> result;
        for (const auto& pair : res) {
            result.push_back(pair.second);
        }
        return result;
    }
};
