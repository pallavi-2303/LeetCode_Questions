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
    //we need to take Two dummy pointer 
ListNode odd=new ListNode(0);
ListNode even=new ListNode(0);
//we also need temp pinter that will travel on node
ListNode tempo=odd;
ListNode tempe=even;
ListNode temp=head;
while(temp!=null){
tempo.next=temp;
tempo=temp;
temp=temp.next;
tempe.next=temp;
tempe=temp;
if(temp!=null) temp=temp.next;
}
even=even.next;
tempo.next=even;
return odd.next;
    }
}