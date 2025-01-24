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
    public ListNode detectCycle(ListNode head) {
      if(head==null || head.next==null)  return null;//as there will be no cycle
//brute force
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
}
return  null;//if there is no cycle   
    }
}