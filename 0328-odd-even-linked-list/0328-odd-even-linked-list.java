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
    public ListNode oddEvenList(ListNode head) {
      ListNode even=new ListNode(0);
ListNode odd=new ListNode(0);
ListNode tempo=odd;
ListNode tempe=even;
ListNode temp=head;
while(temp!=null){
//first connect odd and then even
tempo.next=temp;
tempo=tempo.next;
temp=temp.next;
tempe.next=temp;
tempe=tempe.next;
if(temp!=null)
temp=temp.next;}
tempo.next=even.next;
return odd.next;  
    }
}