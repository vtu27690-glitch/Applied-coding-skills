class Solution {
    public void sortColors(int[] nums) {
        int i = 0, j = 0, k = nums.length - 1;

        while (j <= k) {
            if (nums[j] == 0) {
                int t = nums[i]; nums[i] = nums[j]; nums[j] = t;
                i++; j++;
            } else if (nums[j] == 2) {
                int t = nums[j]; nums[j] = nums[k]; nums[k] = t;
                k--;
            } else {
                j++;
            }
        }
    }
}

Input
nums =
[2,0,2,1,1,0]
Output
[0,0,1,1,2,2]
