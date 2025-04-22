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
    public ListNode middle(ListNode head){
ListNode slow=head;
ListNode fast=head;
while(fast.next.next!=null && fast.next.next.next!=null){
slow=slow.next;
fast=fast.next.next;}
return slow;}
    public ListNode deleteMiddle(ListNode head) {
       if(head==null || head.next==null) return null;
ListNode leftMiddle=middle(head);
ListNode middleNext=leftMiddle.next.next;
leftMiddle.next=middleNext;
return head; 
    }
}