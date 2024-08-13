/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        
        for (int i = 0; i < n + 1; i++) {
            first = first.next;
        }
        
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        second.next = second.next.next;
        
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        ListNode result1 = sol.removeNthFromEnd(head1, 2);
        printList(result1);

        ListNode head2 = new ListNode(1);
        ListNode result2 = sol.removeNthFromEnd(head2, 1);
        printList(result2);

        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        ListNode result3 = sol.removeNthFromEnd(head3, 1);
        printList(result3);
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}