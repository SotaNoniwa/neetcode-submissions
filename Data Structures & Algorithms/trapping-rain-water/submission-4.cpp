class Solution {
   public:
    int trap(vector<int>& height) {
        int l = 0, r = height.size() - 1;
        int max_l = height[l], max_r = height[r];
        int total = 0;
        while (l < r) {
            if (max_l <= max_r) {
                l++;
                max_l = max(height[l], max_l);
                total += max_l - height[l];
            } else {
                r--;
                max_r = max(height[r], max_r);
                total += max_r - height[r];
            }
        }
        return total;
    }
};
