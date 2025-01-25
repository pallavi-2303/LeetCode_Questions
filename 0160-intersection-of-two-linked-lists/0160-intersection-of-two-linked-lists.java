/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
public int countNodes(ListNode head){
 int count=0;
  while(head!=null){
   count++;
   head=head.next;}
   return count;}
public ListNode moveHead(ListNode temp,int idx){
for(int i=1;i<=idx;i++){
 temp=temp.next;}
  return temp;}
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//count the nodes in both cases and node whose length is greater move that to idx places and then move simultaneously 
int sizeA=countNodes(headA);
int sizeB=countNodes(headB);
ListNode tempA=headA;
ListNode tempB=headB;
if(sizeA>sizeB){
int idx=sizeA-sizeB;
tempA=moveHead(tempA,idx);}
else {
int idx=sizeB-sizeA;
tempB=moveHead(tempB,idx);}
while(tempA!=tempB){
tempA=tempA.next;
tempB=tempB.next;}
  return tempA;

        
    }
}