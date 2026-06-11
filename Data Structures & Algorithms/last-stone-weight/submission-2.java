class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int s : stones) {
            maxHeap.add(s);
        }

        System.out.println(maxHeap.size());
        while (maxHeap.size() > 1) {
            int bigStone = maxHeap.poll();
            int smallStone = maxHeap.poll();

            int resStone = bigStone - smallStone;
            if (resStone != 0) {
                maxHeap.add(resStone);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
