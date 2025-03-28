/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
     ListNode slow=head;
ListNode fast=head;
//if there will be a cycle then they tend to meet at a point as fast move by 2 and slow move by 1 distance reduces by 1 there will be time when diff=0;
while(fast!=null && fast.next!=null) {
slow=slow.next;
fast=fast.next.next;
if(slow==fast) return true;
}
return false ;   
    }
}