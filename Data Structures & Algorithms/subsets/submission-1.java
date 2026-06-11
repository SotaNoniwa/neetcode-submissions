class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> allSubsets = new ArrayList<>();

        // num of subsets can be calculated as 2^nums.length since each num has two
        // option, added or not.
        int numOfSubsets = 1 << nums.length;

        // If nums = [1, 2, 3], then 0 (int) = 000 (binary) creates empty set, 1 = 001
        // creates [3], 3 = 011 creates [2, 3].
        for (int i = 0; i < numOfSubsets; i++) {
            List<Integer> subset = convertIntToSet(i, nums);
            allSubsets.add(subset);
        }
        return allSubsets;
    }

    private ArrayList<Integer> convertIntToSet(int binary, int[] nums) {
        ArrayList<Integer> subset = new ArrayList<>();

        int index = 0;
        // Evaluate each bit. If bit = 1, add nums[index], otherwise skip that num.
        for (int i = binary; i != 0; i >>= 1) {
            if ((i & 1) == 1) {
                subset.add(nums[index]);
            }
            index++;
        }
        return subset;
    }
}
