class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int minEatingRate = right;

        while (left <= right) {
            int rate = (left + right) / 2;

            int totalTime = 0;
            for (int p : piles) {
                totalTime += Math.ceil((double) p / rate);
            }
            if (totalTime <= h) {
                minEatingRate = rate;
                right = rate - 1;
            } else {
                left = rate + 1;
            }
        }

        return minEatingRate;
    }
}
