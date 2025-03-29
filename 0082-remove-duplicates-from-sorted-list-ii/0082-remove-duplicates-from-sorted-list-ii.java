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
    public ListNode deleteDuplicates(ListNode head) {
     if(head==null || head.next==null) {
   return head;
}
ListNode newHead=new ListNode(0);
ListNode temp2=newHead;
ListNode temp=head;
while(temp!=null) {
ListNode curr=temp;
int count=1;
while(temp.next!=null && temp.next.val==curr.val) {
count++;
temp=temp.next;
}
if(count==1) {
temp2.next=curr;
temp2=temp2.next;
}
temp=temp.next;
}
temp2.next=null;
return newHead.next;   
    }
}