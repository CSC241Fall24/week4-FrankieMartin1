public class Problem1 {
    public static ListNode concatenate(ListNode l1, ListNode l2) {
        // Handle the case where l1 is null
        if (l1 == null) {
            return copyList(l2); // Return a copy of l2
        }

        // Handle the case where l2 is null
        if (l2 == null) {
            return copyList(l1); // Return a copy of l1
        }

        // Find the last node of l1
        ListNode current = l1;
        while (current.next != null) {
            current = current.next;
        }

        // Append a copy of l2 to the end of l1
        current.next = copyList(l2);
        
        return l1; // Return the modified l1
    }

    // Helper method to create a copy of a list
    private static ListNode copyList(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (head != null) {
            current.next = new ListNode(head.val); // Create a new node
            current = current.next;
            head = head.next; // Move to the next node in the original list
        }

        return dummy.next; // Return the new list
    }
}
