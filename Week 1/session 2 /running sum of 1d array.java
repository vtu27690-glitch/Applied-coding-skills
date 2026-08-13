class Solution {
    public int[] runningSum(int[] nums) {
        // Start from the second element (index 1)
        // Each element becomes the sum of itself plus the previous element
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}

Input
nums =
[1,2,3,4]
Output
[1,3,6,10]
