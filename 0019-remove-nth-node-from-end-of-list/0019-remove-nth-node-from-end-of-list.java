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
        int count=0;
while(head!=null){
    count++;
    head=head.next;
}
return count;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
     //nth node from end means size-n+1 node from the start
    /* if(head==null || (head.next==null && n==1)) return null;
     int size=findSize(head);
     if(size==n) return head.next;
     int m=size-n+1;
     ListNode temp=head;
     for(int i=1;i<m-1;i++) {
        temp=temp.next;
     }  
     temp.next=temp.next.next;
     return head;*/
     ListNode fast=head;
     ListNode slow=head;
     //we need l-n disatnce from the starting point
     for(int i=1;i<=n;i++){
    fast=fast.next;
     }
     if(fast==null){
        return head.next;//because we have to  delete the nth from 
     }
   while(fast.next!=null)  {
    fast=fast.next;
    slow=slow.next;
   }
   slow.next=slow.next.next;
   return head;
    }
}