/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode startingNode(ListNode slow,ListNode fast,ListNode head){
      slow=head;
      while(slow!=fast) {
    slow=slow.next;
    fast=fast.next;
      } 
      return slow;
    }
    public ListNode detectCycle(ListNode head) {
      if(head==null || head.next==null)  return null;//as there will be no cycle
/*brute force
HashMap<ListNode,Integer> mp=new HashMap<>() ;
//if the node is alreaddy present in map means it is the starting point of cycle
ListNode temp=head;
while(temp!=null) {
if(mp.containsKey(temp)){
//means it is staring point of  cycle
return temp;
}
mp.put(temp,1);
temp=temp.next;
}*/
//optimal aproach  of if there is cycle use of tortoise hair algorithm
//in this fast move towards slow by 2 step and slow move away from fast 1 step so disance between slow and fast reduces by 1 step which reduces to 0 and they fially collide
ListNode slow=head;
ListNode fast=head;
while(fast!=null && fast.next!=null){
slow=slow.next;
fast=fast.next.next;
if(slow==fast){
return startingNode(slow,fast,head);
}
}
return  null;//if there is no cycle   
    }
}