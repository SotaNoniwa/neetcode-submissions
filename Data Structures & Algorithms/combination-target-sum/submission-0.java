class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> allCombos = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(nums, target, allCombos, curr, 0);
        return allCombos;
    }

    private void backtrack(
            int[] nums,
            int target,
            List<List<Integer>> allCombos,
            List<Integer> curr,
            int index) {
        if (target == 0) {
            allCombos.add(new ArrayList<>(curr));
        } else if (target >= 0 && index < nums.length) {
            // For each number, we have two possibilities.
            // Possibility 1: Include the num
            curr.add(nums[index]);
            backtrack(nums, target - nums[index], allCombos, curr, index);

            // Possibility 2: Exclude the num
            curr.remove(curr.get(curr.size() - 1));
            backtrack(nums, target, allCombos, curr, index + 1);
        }
    }
}
