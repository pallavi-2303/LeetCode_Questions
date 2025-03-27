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
    //base case
    if(head.next==null){
        return head;
    }
    ListNode newHead=reverse(head.next);
    //self work
//links 4-5 we have to do 5-4
ListNode front=head.next;
front.next=head;
head.next=null;
return newHead;
    }
    public ListNode reverseList(ListNode head) {
    if(head==null || head.next==null) return head;
     /* ListNode temp=head;
      ListNode prev=null;
      while(temp!=null) {
        ListNode Next=temp.next;
        temp.next=prev;
        prev=temp;
        temp=Next;
      } 
      return prev;*/
      //recurssive solution
      return reverse(head);
    }
}