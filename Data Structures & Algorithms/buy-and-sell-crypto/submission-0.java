class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0], maxProf = 0;

        for (int p : prices) {
            minPrice = Math.min(minPrice, p);
            maxProf = Math.max(p - minPrice, maxProf);
        }
        return maxProf;
    }
}
