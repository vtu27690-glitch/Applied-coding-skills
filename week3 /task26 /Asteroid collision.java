import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean alive = true;

            // Collision: positive asteroid vs negative asteroid
            while (alive && asteroid < 0 && !stack.isEmpty() && stack.peek() > 0) {

                if (stack.peek() < -asteroid) {
                    // Stack asteroid is smaller, so it explodes
                    stack.pop();
                } 
                else if (stack.peek() == -asteroid) {
                    // Both asteroids explode
                    stack.pop();
                    alive = false;
                } 
                else {
                    // Current asteroid explodes
                    alive = false;
                }
            }

            if (alive) {
                stack.push(asteroid);
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];

        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}


Input
asteroids =
[5,10,-5]
Output
[5,10]
Expected
[5,10]
