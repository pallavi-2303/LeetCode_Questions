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
    public ListNode deleteMiddle(ListNode head) {
    //brute force fidinng out the middle node by finding the  size 
    if(head==null || head.next==null) return null;
    int n=findSize(head);
    n=n/2;
    ListNode temp=head;
    n-=1;
    while(temp!=null && n>0) {
        temp=temp.next;
        n-=1;
    }
    temp.next=temp.next.next;
    return head;
    }
}