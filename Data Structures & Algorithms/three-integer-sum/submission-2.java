class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            // first = i
            int second = i + 1, third = nums.length - 1;
            while (second < third) {
                int sum = nums[i] + nums[second] + nums[third];

                if (sum > 0)
                    third--;
                else if (sum < 0)
                    second++;
                else {
                    res.add(Arrays.asList(nums[i], nums[second], nums[third]));
                    second++;
                    third--;
                    while (second < third && nums[second] == nums[second - 1])
                        second++;
                }
            }
        }
        return res;
    }
}
