class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        // Count frequency of each task
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Find maximum frequency
        int maxFreq = 0;

        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        // Count how many tasks have maximum frequency
        int countMax = 0;

        for (int f : freq) {
            if (f == maxFreq) {
                countMax++;
            }
        }

        // Calculate minimum intervals
        int result = (maxFreq - 1) * (n + 1) + countMax;

        // We cannot have fewer intervals than total tasks
        return Math.max(result, tasks.length);
    }
}



Input
tasks =
["A","A","A","B","B","B"]
n =
2
Output
8
Expected
8
