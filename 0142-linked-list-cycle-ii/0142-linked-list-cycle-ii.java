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
  public ListNode startNode(ListNode head,ListNode slow,ListNode fast){
slow=head;
  while(slow!=fast){
  slow=slow.next;
   fast=fast.next;}
  //distance is same from starting point that is L1
    return slow;} 
    public ListNode detectCycle(ListNode head) {
ListNode slow=head;
ListNode fast=head;
while(fast!=null && fast.next!=null) {
  slow=slow.next;
  fast=fast.next.next;
  if(slow==fast) {
//collision point
   return startNode(head,slow,fast);} }
   return null;//if no cycle
        
    }
}