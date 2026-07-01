class Solution {
   public:
    int maxProfit(vector<int>& prices) {
        int l = 0;  // buy
        int r = 1;  // sell
        int max_profit = 0;
        while (r < prices.size()) {
            if (prices[l] < prices[r]) {
                max_profit = max(max_profit, prices[r] - prices[l]);
            } else {
                l = r;
            }
            r++;
        }
        return max_profit;
    }
};
