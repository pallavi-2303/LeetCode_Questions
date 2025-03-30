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
    public ListNode findStart(ListNode slow,ListNode fast){
    while(slow!=fast){
    slow=slow.next;
    fast=fast.next;
    }
    return slow;
    }
    public ListNode detectCycle(ListNode head) {
     //brute force 
    /* HashMap<ListNode ,Integer> mp=new HashMap<>();
     ListNode temp=head;
     while(temp!=null){
    if(mp.containsKey(temp)){
        //it is the first visit to node after one time
    return temp;
    }
    mp.put(temp,1);
    temp=temp.next;
     }  
     return null; */
     if(head==null || head.next==null) return null;
     ListNode slow=head;
     ListNode fast=head;
//detecting the cycle
while(fast!=null || fast.next!=null){
slow=slow.next;
fast=fast.next.next;
//if cycle found and slow and fast become zero
if(slow==fast){
   fast=head;
   return findStart(slow,fast); 
}
}
return null;
    }
}