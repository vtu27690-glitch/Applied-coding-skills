class Solution {
    public int findJudge(int n, int[][] trust) {

        int[] degree = new int[n + 1];

        for (int[] t : trust) {
            int a = t[0];
            int b = t[1];

            // a trusts b
            degree[a]--;
            degree[b]++;
        }

        // Judge trusts nobody and everybody else trusts judge
        for (int i = 1; i <= n; i++) {
            if (degree[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}

Input
n =
2
trust =
[[1,2]]
Output
2
Expected
2
