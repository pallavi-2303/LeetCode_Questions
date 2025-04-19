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
    public ListNode merge(ListNode left,ListNode right){
    ListNode dummy=new ListNode(0);
    ListNode  temp=dummy;
    while(left!=null && right!=null){
    if(left.val<=right.val){
    temp.next=left;
    left=left.next;
    }
    else {
    temp.next=right;
    right=right.next;
    }
    temp=temp.next;
    }
if(left==null) temp.next=right;
else temp.next=left;
return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
     if(lists.length==0) return null;
    ListNode head=lists[0];
    int n=lists.length;
    for(int i=1;i<n;i++) {
    head=merge(head,lists[i]);
    } 
    return head; 
    }
}