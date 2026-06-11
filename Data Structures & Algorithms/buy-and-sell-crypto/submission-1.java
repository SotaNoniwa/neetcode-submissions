class Solution {
    public int maxProfit(int[] prices) {
        int maxProf = 0;
        int minPrice = prices[0];

        for (int p : prices) {
            int profit = p - minPrice;
            maxProf = Math.max(maxProf, profit);
            minPrice = Math.min(minPrice, p);
        }

        return maxProf;
    }
}
