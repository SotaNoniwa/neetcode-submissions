class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> allPerms = new ArrayList<>();

        if (nums.length == 1) {
            List<Integer> singleNum = new ArrayList<>();
            singleNum.add(nums[0]);
            allPerms.add(singleNum);
            return allPerms;
        }

        // For each number, find possible permutations
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i]; // Set pivot
            int[] remainingNums = new int[nums.length - 1];
            int idx = 0; // To store remaining nums from index 0
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    remainingNums[idx] = nums[j];
                    idx++;
                }
            }
            List<List<Integer>> perms = permute(remainingNums);

            // Add num to remainingNums's permutation, this is one possible permutation
            for (List<Integer> perm : perms) {
                perm.add(num);
                allPerms.add(new ArrayList<>(perm));
            }
        }
        return allPerms;
    }
}
