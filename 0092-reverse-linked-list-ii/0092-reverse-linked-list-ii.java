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
    while(temp!=null){
    ListNode nextNode=temp.next;
temp.next=prev;
prev=temp;
temp=nextNode;
    }
    return prev;
    }
public ListNode reverseBetween(ListNode head, int left, int right) {
ListNode Left=head;
ListNode prev=null; 
//finding the left Node that has to reversed
for(int i=1;i<left;i++){
prev=Left;
Left=Left.next;
}
//finding the rightnode that has to be revesred
ListNode Right=head;
for(int i=1;i<right;i++){
Right=Right.next;
}
ListNode nextNode=null;
if(Right.next!=null)
nextNode=Right.next;
Right.next=null;
ListNode newHead=reverse(Left);
if(nextNode!=null) Left.next=nextNode;
if(prev==null) return newHead;
if(prev!=null) prev.next=newHead;
return head;


    }
}