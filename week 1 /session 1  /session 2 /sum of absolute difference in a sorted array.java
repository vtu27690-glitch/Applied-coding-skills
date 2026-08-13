class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        long total = 0;

        for (int num : nums) {
            total += num;
        }

        int[] result = new int[n];
        long prefix = 0;

        for (int i = 0; i < n; i++) {
            long left = (long) nums[i] * i - prefix;

            long rightSum = total - prefix - nums[i];
            long right = rightSum - (long) nums[i] * (n - i - 1);

            result[i] = (int) (left + right);

            prefix += nums[i];
        }

        return result;
    }
}


Input
nums =
[2,3,5]
Output
[4,3,5]
Expected
[4,3,5]
