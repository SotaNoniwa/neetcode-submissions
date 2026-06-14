class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> res;
        for (const string& s : strs) {
            array<int, 26> count = {}; // a to z is 26 chars
            for (const char& c : s) {
                count[tolower(c) - 'a']++;
            }
            string key;
            for (const int& occurence : count) {
                // comma at the last e.g. "1,0,1,...," but it doesn't matter
                key += to_string(occurence);
                key += ',';
            }
            res[key].push_back(s);
        }
        vector<vector<string>> result;
        for (const pair<const string, vector<string>>& kv : res) {
            result.push_back(kv.second);
        }
        return result;
    }
};
