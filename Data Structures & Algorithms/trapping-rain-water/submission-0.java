class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int lMax = height[l], rMax = height[r];
        int amount = 0;

        while (l < r) {
            if (lMax < rMax) {
                if (lMax - height[l] > 0)
                    amount += lMax - height[l];
                l++;
                lMax = Math.max(lMax, height[l]);
            } else {
                if (lMax - height[r] > 0)
                    amount += rMax - height[r];
                r--;
                rMax = Math.max(rMax, height[r]);
            }
        }
        return amount;
    }
}
