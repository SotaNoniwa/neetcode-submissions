class MedianFinder {
    private Queue<Integer> minHeap;
    private Queue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if (minHeap.isEmpty() || minHeap.peek() <= num) {
            minHeap.add(num);
        } else{
            maxHeap.add(num);
        }

        if (minHeap.size() - maxHeap.size() > 1) {
            int n = minHeap.poll();
            maxHeap.add(n);
        } else if (maxHeap.size() - minHeap.size() > 1) {
            int n = maxHeap.poll();
            minHeap.add(n);
        }
    }

    public double findMedian() {
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return (double) (minHeap.peek() + maxHeap.peek()) / 2;
        }
    }
}