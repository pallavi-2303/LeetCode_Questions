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
    if(head.next==null){
    return head;
    }
   ListNode newHead=reverse(head.next);
  //4-5 5-4
  ListNode front=head.next;
  front.next=head;
  head.next=null;
return newHead;

    }
    public ListNode reverseList(ListNode head) {
   /*    ListNode temp=head;
ListNode prev=null;
while(temp!=null){
ListNode nextNode=temp.next;
temp.next=prev;
prev=temp;
temp=nextNode;}
return prev; */
if(head==null || head.next==null) return null;
return reverse(head);

    }
}