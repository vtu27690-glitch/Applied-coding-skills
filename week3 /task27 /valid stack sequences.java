import java.util.*;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0; // pointer for popped array

        for (int value : pushed) {
            stack.push(value);

            // Pop while the stack top matches popped[j]
            while (!stack.isEmpty() && j < popped.length
                    && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();
    }
}

Input
pushed =
[1,2,3,4,5]
popped =
[4,5,3,2,1]
Output
true
Expected
true
