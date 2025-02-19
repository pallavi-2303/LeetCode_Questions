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
    public ListNode mergeKLists(ListNode[] lists) {
     if(lists==null || lists.length==0)   return null;
     PriorityQueue<ListNode> pq=new PriorityQueue<>((x,y)->Integer.compare(x.val,y.val));
     for(ListNode node:lists){
    if(node!=null){
    pq.offer(node);
    }
     }
     ListNode dummy=new ListNode(0);
     ListNode temp=dummy;
     while(!pq.isEmpty()){
    ListNode curr=pq.poll();
     if(curr.next!=null){
     pq.offer(curr.next);
    }
    temp.next=curr;
    temp=curr;
     }
return dummy.next;
    }
}