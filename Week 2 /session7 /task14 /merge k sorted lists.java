import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        // Min-heap based on node value
        PriorityQueue<ListNode> pq =
            new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the first node of each non-empty list
        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }

        // Dummy node for easier construction
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!pq.isEmpty()) {

            // Get the smallest node
            ListNode node = pq.poll();

            // Add it to the merged list
            current.next = node;
            current = current.next;

            // Add the next node from the same list
            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummy.next;
    }
}


Input
lists =
[[1,4,5],[1,3,4],[2,6]]
Output
[1,1,2,3,4,4,5,6]
Expected
[1,1,2,3,4,4,5,6]
