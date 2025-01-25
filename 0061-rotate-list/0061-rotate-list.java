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
    public ListNode kthNode(ListNode head,int k){
 k-=1;
 while(head!=null && k>0){
  head=head.next;
  k-=1;
 }
 return head;
}
    public ListNode rotateRight(ListNode head, int k) {
       if(head==null || head.next==null)
return head;
ListNode tail=head;
int len=1;
while(tail.next!=null) {
tail=tail.next;
len++;
}
if(len==k) return head;
k=k%len;
ListNode kthNode=kthNode(head,len-k);
tail.next=head;
head=kthNode.next;
kthNode.next=null;
return head; 
    }
}