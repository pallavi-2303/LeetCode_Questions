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
     //using priority  queue as it will give the smallest  element on top
   if(lists==null || lists.length==0) return null;
   PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->(Integer.compare(a.val,b.val)));
 for(ListNode node:lists) {
if(node!=null){
pq.offer(node);
 }}
 ListNode dummy=new ListNode(0);
 ListNode temp=dummy;
 while(!pq.isEmpty()) {
ListNode curr=pq.poll();
if(curr.next!=null){
pq.offer(curr.next);
}
temp.next=curr;
temp=temp.next;
 }
return dummy.next;  
    }
}