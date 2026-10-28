
import java.util.*;

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] bit = new int[20002];
        Integer[] result = new Integer[n];

        for (int i = n - 1; i >= 0; i--) {
            int index = nums[i] + 10001;

            int sum = 0;
            for (int j = index - 1; j > 0; j -= j & -j) {
                sum += bit[j];
            }

            result[i] = sum;

            for (int j = index; j < bit.length; j += j & -j) {
                bit[j]++;
            }
        }

        return Arrays.asList(result);
    }
}

