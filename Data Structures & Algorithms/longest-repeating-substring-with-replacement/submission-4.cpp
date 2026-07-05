class Solution {
   public:
    int characterReplacement(string s, int k) {
        int alpha[26] = {0};
        int l = 0;
        int freq = 0;
        int max_len = 0;
        for (int r = 0; r < s.length(); r++) {
            alpha[s[r] - 'A']++;
            freq = max(freq, *max_element(alpha, alpha + 26));
            while (r - l + 1 - freq > k) {
                alpha[s[l] - 'A']--;
                l++;
            }
            max_len = max(max_len, r - l + 1);
        }
        return max_len;
    }
};
