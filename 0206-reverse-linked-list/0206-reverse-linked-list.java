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
    public ListNode reverse(ListNode head){
ListNode prev=null;
ListNode temp=head;
while(temp!=null){
ListNode Next=temp.next;
temp.next=prev;
prev=temp;
temp=Next;}
return prev;}
    public ListNode reverseList(ListNode head) {
       if(head==null || head.next==null) return head;
       return reverse(head);
    }
}