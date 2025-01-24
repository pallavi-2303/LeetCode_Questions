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
    ListNode temp=head;
    ListNode prev=null;
    while(temp!=null) {
   ListNode NextNode=temp.next;
   temp.next=prev;
   prev=temp;
   temp=NextNode;
    }
    return prev;   
    }
   public ListNode leftMiddle(ListNode head) {
    ListNode slow=head;
    ListNode fast=head;
    while(fast.next!=null && fast.next.next!=null){
        slow=slow.next;
        fast=fast.next.next;
    }
    return slow;
   }
    public boolean isPalindrome(ListNode head) {
    //step-1 finding the middle node and in case of even node finding the left middle
 if(head==null || head.next==null) return true;
  ListNode slow=leftMiddle(head);
  ListNode Right=reverse(slow.next);
  ListNode p1=head;
  ListNode p2=Right;
  while(p1!=null && p2!=null){
if(p1.val!=p2.val){
    Right=reverse(Right);
slow.next=Right;
 return false;}
p1=p1.next;
p2=p2.next;
  }
//again making the node it was before
Right=reverse(Right);
slow.next=Right;
return true;//if it is palindrome
    }
}