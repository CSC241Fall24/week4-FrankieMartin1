
public class Problem2 {
    public static ListNode insert(ListNode head, int val, int position) {
        ListNode newNode = new ListNode(val);
        
        // If inserting at the head (position 1)
        if (position == 1) {
            newNode.next = head;
            return newNode; // New node becomes the new head
        }
        
        // Traverse the list to find the position before where we want to insert
        ListNode current = head;
        int currentIndex = 1;

        // Move to the position just before where the new node should be inserted
        while (current != null && currentIndex < position - 1) {
            current = current.next;
            currentIndex++;
        }

        // If current is null, we are at the end of the list, insert at the end
        if (current == null) {
            return appendToTail(head, newNode);
        } else {
            // Insert in the middle of the list
            newNode.next = current.next;
            current.next = newNode;
        }

        return head; // Return the original head of the list
    }

    private static ListNode appendToTail(ListNode head, ListNode newNode) {
        if (head == null) {
            return newNode; // If the list is empty, return the new node as the head
        }

        ListNode current = head;
        while (current.next != null) {
            current = current.next; // Traverse to the end
        }
        current.next = newNode; // Append the new node at the end
        return head; // Return the original head
    }
}
