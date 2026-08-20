class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {

            // Save the next node
            ListNode next = current.next;

            // Reverse the pointer
            current.next = prev;

            // Move prev forward
            prev = current;

            // Move current forward
            current = next;
        }

        return prev;
    }
}

Input
head =
[1,2,3,4,5]
Output
[5,4,3,2,1]
Expected
[5,4,3,2,1]
