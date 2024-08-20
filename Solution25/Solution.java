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
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;
        
        while (true) {
            ListNode groupStart = prevGroupEnd.next;
            ListNode groupEnd = prevGroupEnd;
            int count = 0;
            
            while (groupEnd != null && count < k) {
                groupEnd = groupEnd.next;
                count++;
            }
            
            if (groupEnd == null) break;
            
            ListNode nextGroupStart = groupEnd.next;
            ListNode prev = nextGroupStart;
            ListNode current = groupStart;
            
            while (current != nextGroupStart) {
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            
            prevGroupEnd.next = groupEnd;
            prevGroupEnd = groupStart;
        }
        
        return dummy.next;
    }
}
