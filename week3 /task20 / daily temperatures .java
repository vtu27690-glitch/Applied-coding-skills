import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            // Check if today's temperature is warmer
            while (!stack.isEmpty() &&
                   temperatures[i] > temperatures[stack.peek()]) {

                int prevDay = stack.pop();

                answer[prevDay] = i - prevDay;
            }

            // Store today's index
            stack.push(i);
        }

        return answer;
    }
}


Input
temperatures =
[73,74,75,71,69,72,76,73]
Output
[1,1,4,2,1,1,0,0]
Expected
[1,1,4,2,1,1,0,0]
