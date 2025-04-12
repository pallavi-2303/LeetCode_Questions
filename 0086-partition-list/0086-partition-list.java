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
    public ListNode partition(ListNode head, int x) {
     ListNode small=new ListNode(0);
    ListNode large=new ListNode(0);
    ListNode temp=head;
    ListNode smallpointer=small;
    ListNode largepointer=large;
    while(temp!=null) {
    if(temp.val<x){
    smallpointer.next=temp;
    smallpointer=smallpointer.next;
    }
    else {
    largepointer.next=temp;
    largepointer=largepointer.next;
    }
    temp=temp.next;
    } 
    smallpointer.next=large.next;
    largepointer.next=null;
    return small.next;
    }
}