class MinRotateSort {
    // Method to find the minimum element in a rotated sorted array
    // Time complexity: O(log n) - Binary search
    // Space complexity: O(1) - Constant space
    public int findMin(int[] nums) {
        // Check if the array is null or empty
        if (nums == null || nums.length == 0)
            return -1;
            
        // Length of the array
        int n = nums.length;
        // Initialize pointers for binary search
        int low = 0;
        int high = n - 1;
        
        // Binary search loop
        while (low <= high) {
            // If the array is not rotated, return the first element
            if (nums[low] <= nums[high])
                return nums[low];
            
            // Calculate the middle index
            int mid = low + (high - low) / 2;
            
            // Check if mid is not at the beginning and if the current element is less than the previous one
            if (mid != 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if (nums[low] <= nums[mid]) {
                // If the left half is sorted, move to the right half
                low = mid + 1;
            } else{
                // If the right half is sorted, move to the left half
                high = mid - 1;
            }
        }
        
        // In case of a non-rotated array, return a default value
        return 799;
    }
    
    // Main function to test the findMin method
    public static void main(String[] args) {
        // Create an instance of the MinRotateSort class
        MinRotateSort solution = new MinRotateSort();
        
        // Test cases
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Minimum element: " + solution.findMin(nums1)); // Output: 0
        
        int[] nums2 = {3, 4, 5, 1, 2};
        System.out.println("Minimum element: " + solution.findMin(nums2)); // Output: 1
        
        int[] nums3 = {11, 13, 15, 17};
        System.out.println("Minimum element: " + solution.findMin(nums3)); // Output: 11
    }
}
