class Solution {
   public:
    int trap(vector<int>& height) {
        int l = 0, r = height.size() - 1;
        int max_l = height[l], max_r = height[r];
        int total = 0;
        while (l < r) {
            if (max_l <= max_r) {
                l++;
                int trapped = max_l - height[l];
                if (trapped < 0) {
                    trapped = 0;
                }
                total += trapped;
                max_l = max(height[l], max_l);
            } else {
                r--;
                int trapped = max_r - height[r];
                if (trapped < 0) {
                    trapped = 0;
                }
                total += trapped;
                max_r = max(height[r], max_r);
            }
        }
        return total;
    }
};
