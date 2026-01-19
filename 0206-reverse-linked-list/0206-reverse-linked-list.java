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
    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        while(temp!=null) { 
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
}

/** 
temp = head
prev = null


temp -> next = prev
but this breaks the previous link so we'll store the next in other node
let say : front = temp -> next
then : temp -> next = prev


now moving the temp to front place for next iteration
temp = front
but this also makes lost the prev
so we'll make sure to update the prev
by : prev = temp
then : temp = front



put all this in while unitl the temp becomes null
*/