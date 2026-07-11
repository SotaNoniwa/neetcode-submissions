class Solution {
   public:
    string minWindow(string s, string t) {
        if (t.empty()) return "";

        unordered_map<char, int> count_t, window;
        for (const char& c : t) {
            count_t[c]++;
        }

        int have = 0, need = count_t.size();
        int res_l = -1;
        int res_len = INT_MAX;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s[r];
            window[c]++;

            if (count_t.contains(c) && window[c] == count_t[c]) {
                have++;
            }

            while (have == need) {
                if ((r - l + 1) < res_len) {
                    res_len = r - l + 1;
                    res_l = l;
                }

                window[s[l]]--;
                if (count_t.contains(s[l]) && window[s[l]] < count_t[s[l]]) {
                    have--;
                }
                l++;
            }
        }
        return res_len == INT_MAX ? "" : s.substr(res_l, res_len);
    }
};
