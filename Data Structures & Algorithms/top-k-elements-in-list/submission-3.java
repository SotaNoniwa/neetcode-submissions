class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numFreqMap = new HashMap<>();
        List<List<Integer>> freqList = new ArrayList<>(nums.length + 1);

        for (int n : nums) {
            numFreqMap.put(n, numFreqMap.getOrDefault(n, 0) + 1);
        }

        for (int i = 0; i < nums.length + 1; i++) {
            freqList.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry : numFreqMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            freqList.get(freq).add(num);
        }

        int[] topK = new int[k];
        int idx = 0;
        for (int i = freqList.size() - 1; i > 0; i--) {
            for (int num : freqList.get(i)) {
                topK[idx] = num;
                idx++;
                if (idx == k) {
                    return topK;
                }
            }
        }
        return new int[] {};
    }
}
