class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        ArrayList<ArrayList<Integer>> freq = new ArrayList<>(nums.length + 1);

        for (int n : nums)
            count.put(n, count.getOrDefault(n, 0) + 1);

        for (int i = 0; i < nums.length + 1; i++)
            freq.add(new ArrayList<>());

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq.get(entry.getValue()).add(entry.getKey());
        }

        int[] ans = new int[k];
        int index = 0;
        for (int i = freq.size() - 1; i > 0 && index < k; i--) {
            for (int n : freq.get(i)) {
                ans[index] = n;
                index++;
                if (index == k)
                    return ans;
            }
        }

        return ans;
    }
}
