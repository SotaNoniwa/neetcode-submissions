class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> allCombos = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), allCombos);
        return allCombos;
    }

    private void backtrack(
            int[] candidates,
            int target,
            int index,
            List<Integer> combo,
            List<List<Integer>> allCombos) {
        // Found one combination
        if (target == 0) {
            allCombos.add(new ArrayList<>(combo));
            return;
        }

        // Sum of combination exceed target value, then stop searching this branch
        if (target < 0) {
            return;
        }

        int prev = -1;
        for (int i = index; i < candidates.length; i++) {
            // Skip the same number as the previous one
            if (candidates[i] == prev) {
                continue;
            }

            combo.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, combo, allCombos);

            combo.remove(combo.size() - 1);
            prev = candidates[i];
        }
    }
}
