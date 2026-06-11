class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numFreqMap = new HashMap<>();
        List<List<Integer>> freqList = new ArrayList<>(nums.length + 1);
        // count frequency of numbers and store them in HashMap
        for (int n : nums) {
            numFreqMap.put(n, numFreqMap.getOrDefault(n, 0) + 1);
        }
        // Initialize empty ArrayList to add each freq-num pair into freqList
        for (int i = 0; i < nums.length + 1; i++) {
            freqList.add(new ArrayList<>());
        }
        // Add values to freqList, index = freq, value = [num1, num2, ...]
        for (Map.Entry<Integer, Integer> entry : numFreqMap.entrySet()) {
            int num = entry.getKey(), freq = entry.getValue();
            freqList.get(freq).add(num);
        }

        int[] topK = new int[k];
        int idx = 0;
        for (int i = freqList.size() - 1; i > 0 && idx < k; i--) {
            for (int num : freqList.get(i)) {
                topK[idx] = num;
                idx++;
                if (idx == k) {
                    return topK;
                }
            }
        }
        // if we have no sufficient element in nums, return empty array (never reach
        // here)
        return new int[] {};
    }
}
