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
ListNode nextNode=temp.next;
temp.next=prev;
prev=temp;
temp=nextNode;
}
return prev;
}
public ListNode findkthNode(ListNode head,int k) {
k-=1;
while(head!=null && k>0) {
head=head.next;
k--;
}
return head;
}
    public ListNode reverseKGroup(ListNode head, int k) {
      ListNode temp=head;
ListNode prev=null;
while(temp!=null) {
ListNode kthNode=findkthNode(temp,k);
if(kthNode==null) {
if(prev!=null) 
prev.next=temp;
break;
}
//since we have to break the kthnode next to reverse it we have to store it's next Node
ListNode nextNode=kthNode.next;
kthNode.next=null;
reverse(temp);
//if it is first reversal
if(head==temp) {
head=kthNode;
}
else {
prev.next=kthNode;}
prev=temp;
temp=nextNode;
}
return head;  
    }
}