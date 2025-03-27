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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       ListNode temp1=l1;
ListNode temp2=l2;
ListNode dummy=new ListNode(0);
ListNode temp=dummy;
while(temp1!=null && temp2!=null){
if(temp1.val<=temp2.val){
temp.next=temp1;
temp=temp.next;
temp1=temp1.next;}
else {
temp.next=temp2;
temp=temp.next;
temp2=temp2.next;}}
if(temp1==null)
temp.next=temp2;
else
temp.next=temp1; 
return dummy.next;
    }
}