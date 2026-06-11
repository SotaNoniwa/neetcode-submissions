class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), allSubsets);
        return allSubsets;
    }

    private void backtrack(int[] nums, int startIdx, List<Integer> subset, List<List<Integer>> allSubsets) {
        allSubsets.add(new ArrayList<>(subset));
        for (int i = startIdx; i < nums.length; i++) {
            if (i > startIdx && nums[i] == nums[i - 1]) {
                continue; // Skip the same number as previous one
            }
            subset.add(nums[i]);
            backtrack(nums, i + 1, subset, allSubsets);
            subset.remove(subset.size() - 1);
        }
    }
}
