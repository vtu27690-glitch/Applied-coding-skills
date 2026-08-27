public class Solution {
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Find whether a cycle exists
        while (fast != null && fast.next != null) {

            slow = slow.next;           // moves 1 step
            fast = fast.next.next;      // moves 2 steps

            if (slow == fast) {
                // Cycle found
                break;
            }
        }

        // No cycle
        if (fast == null || fast.next == null) {
            return null;
        }

        // Step 2: Find the starting node of the cycle
        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}

Input
head =
[3,2,0,-4]
pos =
1
Output
tail connects to node index 1
Expected
tail connects to node index 1
