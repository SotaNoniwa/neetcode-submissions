
// Quick sort
// Time complexity: O(n) in average, O(n^2) in worst case
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Calculation to determine whether Kth largest element is in left or right
        // partition
        int target = nums.length - k;

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int pivot = partition(nums, left, right);

            if (pivot < target) { // target value is in right partition
                left = pivot + 1;
            } else if (pivot > target) { // target value is in left partition
                right = pivot - 1;
            } else { // pivot is the target
                break;
            }
        }
        return nums[target];
    }

    private int partition(int[] nums, int left, int right) {
        int pivotVal = nums[right];
        int prev = left; // index to swap with pivot

        // Making left partition
        for (int curr = left; curr < right; curr++) {
            if (nums[curr] <= pivotVal) {
                swap(nums, prev, curr);
                prev++;
            }
        }
        // Insert pivot in the middle of left and right partitions
        swap(nums, prev, right);
        // after swapping, prev is now the index of pivot
        return prev;
    }

    private int[] swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
        return nums;
    }
}

