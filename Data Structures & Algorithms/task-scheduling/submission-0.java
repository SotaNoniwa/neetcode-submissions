class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Use Map to organize each task and its counts
        Map<Character, Integer> counts = new HashMap<>();
        for (char task : tasks) {
            counts.put(task, counts.getOrDefault(task, 0) + 1);
        }

        // Use maxHeap to always complete the most frequent task first
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(counts.values());

        int time = 0;
        // Use Queue to arrange tasks in order
        Deque<int[]> scheduler = new ArrayDeque<>();
        while (!maxHeap.isEmpty() || !scheduler.isEmpty()) {
            // There is still task, and the task is ready to be executed
            if (!scheduler.isEmpty() && time >= scheduler.peek()[1]) {
                maxHeap.add(scheduler.poll()[0]);
            }
            // Execute task. If there is identical task, put it to scheduler
            if (!maxHeap.isEmpty()) {
                int cnt = maxHeap.poll() - 1;
                if (cnt > 0) {
                    scheduler.add(new int[] { cnt, time + n + 1 });
                }
            }
            time++;
        }
        return time;
    }
}
