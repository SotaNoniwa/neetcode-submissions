#include <set>

class Solution {
public:
    bool hasDuplicate(vector<int>& nums) {
            std:set<int> tmp_set = {};
            for(const int& num: nums) {
                if (tmp_set.contains(num)) {
                    return true;
                }
                tmp_set.insert(num);
            }
            return false;
    }
};