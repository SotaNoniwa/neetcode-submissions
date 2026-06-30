class Solution {
   public:
    int maxArea(vector<int>& heights) {
        int max = 0;
        int l = 0;
        int r = heights.size() - 1;
        while (l < r) {
            int height = heights[l] < heights[r] ? heights[l] : heights[r];
            int current = height * (r - l);
            max = current > max ? current : max;
            if (heights[l] <= heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
};
