class Solution {
   public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int> num_set(nums.begin(), nums.end());
        int longest = 0;
        for (int& n : nums) {
            if (!num_set.contains(n - 1)) {
                int len = 1;
                while (num_set.contains(n + 1)) {
                    len++;
                    n++;
                }
                if (len > longest) {
                    longest = len;
                }
            }
        }
        return longest;
    }
};
