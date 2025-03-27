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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode temp1=l1;
ListNode temp2=l2;
ListNode dummy=new ListNode(0);
ListNode temp=dummy;
int sum=0;
int carry=0;
while(temp1!=null || temp2!=null){
sum=carry;
if(temp1!=null) {
sum+=temp1.val;}
if(temp2!=null){
sum+=temp2.val;}
ListNode newNode=new  ListNode(sum%10);
carry=sum/10;
temp.next=newNode;
temp=temp.next;
 if(temp1!=null) temp1=temp1.next;
 if(temp2!=null) temp2=temp2.next;}
if(carry==0) return dummy.next;
ListNode newNode=new ListNode(carry);
temp.next=newNode;
return dummy.next;  
    }
}