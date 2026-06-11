class Solution {
    // Method 1: O(n) time, O(n) space
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProduct = new int[nums.length];
        int multiplyFactor = 1;
        for (int i = 0; i < nums.length; i++) {
            multiplyFactor *= nums[i];
            prefixProduct[i] = multiplyFactor;
        }

        int[] postfixProduct = new int[nums.length];
        multiplyFactor = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            multiplyFactor *= nums[i];
            postfixProduct[i] = multiplyFactor;
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[i] = postfixProduct[i + 1];
            } else if (i == nums.length - 1) {
                result[i] = prefixProduct[i - 1];
            } else {
                result[i] = prefixProduct[i - 1] * postfixProduct[i + 1];
            }
        }

        return result;
    }
}  
