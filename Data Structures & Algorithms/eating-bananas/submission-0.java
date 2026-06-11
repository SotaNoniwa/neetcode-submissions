class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int minK = r;

        while (l <= r) {
            int k = (l + r) / 2;
            int totalHours = 0;
            for (int p : piles) {
                totalHours += Math.ceil((double) p / k);
            }
            if (totalHours <= h) {
                minK = k;
                r = k - 1;
            } else {
                l = k + 1;
            }
        }
        return minK;
    }
}
