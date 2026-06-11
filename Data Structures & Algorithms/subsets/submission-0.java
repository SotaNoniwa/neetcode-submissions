class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(nums, 0, subset, allSubsets);
        return allSubsets;
    }

    private void backtrack(int[] nums, int index, List<Integer> subset, List<List<Integer>> allSubsets) {
        if (index >= nums.length) {
            allSubsets.add(new ArrayList<>(subset));
            return;
        }
        
        // There are two options for each number.
        // Option 1: Include the number
        subset.add(nums[index]);
        backtrack(nums, index + 1, subset, allSubsets);

        // Option 2: Exclude the number
        subset.remove(subset.size() - 1);
        backtrack(nums, index + 1, subset, allSubsets);
    }
}
