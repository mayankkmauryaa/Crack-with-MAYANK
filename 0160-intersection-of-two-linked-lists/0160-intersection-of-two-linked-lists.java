/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        int len1 = 0;
        int len2 = 0 ;
        while(node1!=null){
            len1++;
            node1=node1.next;
        }
        while(node2!=null){
            len2++;
            node2=node2.next;
        }
        node1=headA;
        node2=headB;
        int m = 0 ;
        if(len1>len2){
            m=len1-len2;
            for(int i = 0 ; i<m;i++) node1=node1.next;
        }
        else {
            m=len2-len1;
            for(int i = 0 ; i<m ; i++) node2=node2.next;
        }
        while(node1!=node2){
            node1=node1.next;
            node2=node2.next;
        }
        return node2; // or we can also return node 1
    }
}
