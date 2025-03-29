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
    public ListNode findKthNode(ListNode head,int k){
    k-=1;
    while(head!=null && k>0){
    head=head.next;
    k-=1;
    }
    return head;
    }
    public ListNode rotateRight(ListNode head, int k) {
     //we want  the kthNode from beginning whose next node will be our head;
     if(head==null || head.next==null) return head;
     ListNode tail=head;
     int size=1;
     while(tail.next!=null) {
    tail=tail.next;
    size++;
     } 
if(size==k) return head;
k=k%size;
ListNode kthNode=findKthNode(head,size-k);
tail.next=head;
head=kthNode.next;
kthNode.next=null;
return head;

    }
}