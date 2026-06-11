class Solution {
    public int findDuplicate(int[] nums) {
        // Consider array as LinkedList, use Floyd's Tortise & Hare
        int slow = 0, fast = 0;

        // Find the collision spot
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }

        fast = 0; // Move fast to head
        while (true) {
            // Move slow and fast one for each step.
            slow = nums[slow];
            fast = nums[fast];
            // The point where they meet is the beginning of cycle
            if (slow == fast) {
                return slow;
            }
        }
    }
}
