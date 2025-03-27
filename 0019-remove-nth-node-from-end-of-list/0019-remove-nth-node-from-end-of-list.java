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
    public int findSize(ListNode head){
int size=0;
while(head!=null){
size++;
head=head.next;}
return size;}
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //last NTh Node means starting se size-n+1 th node
if((head==null || head.next==null) && n==1) return null;
/*int size=findSize(head);
if(size==n) return head.next;
int m=size-n+1;
ListNode temp=head;
for(int i=1;i<m-1;i++){
temp=temp.next;}
temp.next=temp.next.next;
return head;*/
ListNode slow=head;
ListNode fast=head;
//since we want to come before the node to be deleted size-n
for(int i=1;i<=n;i++){
fast=fast.next;
}
if(fast==null) return head.next;
while(fast.next!=null){
fast=fast.next;
slow=slow.next;
}
slow.next=slow.next.next;
return head;
    }
}