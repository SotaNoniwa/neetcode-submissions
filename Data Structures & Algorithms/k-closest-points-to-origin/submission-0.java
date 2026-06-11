class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Store [distance, xPos, yPos], sorting based on the distance
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));

        // Calculate distance, store [distance, xPos, yPos] into minHeap
        for (int[] p : points) {
            int distance = p[0] * p[0] + p[1] * p[1];
            minHeap.add(new int[] { distance, p[0], p[1] });
        }

        int[][] kClosestPoints = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] point = minHeap.poll();
            kClosestPoints[i] = new int[] { point[1], point[2] };
        }

        return kClosestPoints;
    }
}
