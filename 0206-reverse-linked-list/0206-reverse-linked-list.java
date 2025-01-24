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
public ListNode reverseNode(ListNode head){
//Base case
if(head.next==null){
   return head;}
//recirsive work
ListNode newhead=reverseNode(head.next);
//self work
//4 -5 newhead=5 rev->5 4
   ListNode front=head.next;   
    front.next=head;    
    head.next=null;    
    return newhead;}    
    public ListNode reverseList(ListNode head) {
            if(head==null || head.next==null){
  return head;}
//iterative-> prev temp front
/*ListNode temp=head;
ListNode prev=null;
  while(temp!=null){
//store the next node of temp to go in next round 
 ListNode front=temp.next;
 temp.next=prev;
  prev=temp;
 temp=front;}
      return prev;*/
 return reverseNode(head);
  
    
        
    }
}