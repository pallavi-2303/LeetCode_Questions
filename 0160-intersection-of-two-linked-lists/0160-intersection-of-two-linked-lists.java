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
    public int findSize(ListNode head){
int size=0;
while(head!=null){
size++;
head=head.next;}
return size;}
    public ListNode findInterSection(ListNode headA,ListNode headB) {
while(headA!=headB) {
headA=headA.next;
headB=headB.next;
}
return headA;
}
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       // finding the size of LinkedList
int sizeA=findSize(headA);
int sizeB=findSize(headB);
int diff=0;
if(sizeA>sizeB) {
 diff=sizeA-sizeB;
 for(int i=1;i<=diff;i++){
headA=headA.next;
 }
}
else {
diff=sizeB-sizeA;
for(int i=1;i<=diff;i++){
headB=headB.next;
 }
}
return findInterSection(headA,headB);
    }
}