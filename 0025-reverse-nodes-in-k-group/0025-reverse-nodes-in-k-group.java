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
public ListNode reverseLL(ListNode head){
ListNode temp=head;
ListNode prev=null;
while(temp!=null){
ListNode front=temp.next;
temp.next=prev;
 prev=temp;
 temp=front;}
 return prev;}
 public ListNode findKThNode(ListNode temp,int k){
k=k-1;
while(temp!=null && k>0){
temp=temp.next;
 k-=1;}
 return temp;}
    public ListNode reverseKGroup(ListNode head, int k) {
 ListNode temp=head;
ListNode PrevNode=null;
while(temp!=null){
ListNode kthNode=findKThNode(temp,k);
//if KTHNode is null
 if(kthNode==null){
if(PrevNode!=null){
 //it is in last portion
  PrevNode.next=temp;
    break;}}
ListNode NextNode=kthNode.next;
 kthNode.next=null;
 //reverse K portion of LL
 reverseLL(temp);
 //now kth Node will be head if it is first occursence
 if(temp==head){
  head=kthNode;}
  else {
  //connect prevlast to kth node
  PrevNode.next=kthNode;}
//after reversal temp become prev Node
 PrevNode=temp;
 temp=NextNode;}
   return head;
        
    }
}