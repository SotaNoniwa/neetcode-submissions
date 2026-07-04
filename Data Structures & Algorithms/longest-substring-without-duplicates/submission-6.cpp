class Solution {
   public:
    int lengthOfLongestSubstring(string s) {
        unordered_set<char> seen;
        int l = 0;
        int len = 0;
        for (int r = 0; r < s.length(); r++) {
            while (seen.contains(s[r])) {
                seen.erase(s[l]);
                l++;
            }
            seen.insert(s[r]);
            len = max(r - l + 1, len);
        }
        return len;
    }
};
