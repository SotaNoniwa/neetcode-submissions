class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int numOfCars = position.length;
        // Create new array of pair: position, speed
        double[][] pairs = new double[numOfCars][2];
        for (int i = 0; i < numOfCars; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        // Sort pairs based on their position
        Arrays.sort(pairs, (pair1, pair2) -> Double.compare(pair2[0], pair1[0]));

        int fleetCount = 0;
        double[] timeToReach = new double[numOfCars];
        for (int i = 0; i < numOfCars; i++) {
            timeToReach[i] = (target - pairs[i][0]) / pairs[i][1];
            // current car will catch up previous car (they become a fleet)
            if (i >= 1 && timeToReach[i] <= timeToReach[i - 1]) {
                timeToReach[i] = timeToReach[i - 1];
            } else {
                fleetCount++;
            }
        }

        return fleetCount;
    }
}
