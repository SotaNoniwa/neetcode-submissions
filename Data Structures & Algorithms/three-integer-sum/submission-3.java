class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> allSums = new ArrayList<>();
        // num1Idx + num2 + num3 = 0
        for (int num1Idx = 0; num1Idx < nums.length; num1Idx++) {
            // Skip duplicat elements
            if (num1Idx > 0 && nums[num1Idx] == nums[num1Idx - 1]) {
                continue;
            }

            int left = num1Idx + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[num1Idx] + nums[left] + nums[right];

                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    allSums.add(Arrays.asList(nums[num1Idx], nums[left], nums[right]));
                    left++;
                    right--;
                    // Skip duplicate element
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }
        return allSums;
    }
}
