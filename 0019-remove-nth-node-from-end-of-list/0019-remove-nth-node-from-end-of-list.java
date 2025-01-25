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
  public int CountNodes(ListNode head){
 int count=0;
 while(head!=null) {
 count++;
 head=head.next;
 }
 return count;
}
    public ListNode removeNthFromEnd(ListNode head, int n) {
  //nth Node from last means mth node from start
/*int size=CountNodes(head);
int m=size-n+1;
if(m==1) return head.next;
ListNode temp=head;
for(int i=1;i<m-1;i++){
  temp=temp.next;
}
temp.next=temp.next.next;
            return head;*/
 //intution -> first we move fast by n places and then fast reaches last node means by moving slow and fast at same distance means slow is at just before L-n node 
 ListNode fast=head;
ListNode slow=head;
//first move fast by n places
for(int i=1;i<=n;i++){
 fast=fast.next;}
if(fast==null) // n=size of node
 return head.next;
while(fast.next!=null){
slow=slow.next;
fast=fast.next;}

slow.next=slow.next.next;
     return head;
        
            
        
    }
}