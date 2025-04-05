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
   public ListNode findMiddle(ListNode head){
    ListNode fast=head;
    ListNode slow=head;
   while(fast.next!=null && fast.next.next!=null) {
    slow=slow.next;
    fast=fast.next.next;
   }
   return slow;
   }
   public ListNode merge(ListNode left,ListNode right){
    ListNode head=new ListNode(0);
    ListNode temp=head;
  while(left!=null && right!=null) {
if(left.val<=right.val){
temp.next=left;
temp=left;
left=left.next;
}
else{
    temp.next=right;
    temp=right;
    right=right.next;
}
  } 
if(left==null) temp.next=right;
else temp.next=left;
return head.next;
   }
    public ListNode sortList(ListNode head) {
    //brute force putting in aaray amd sorting it and then converting in lined list
  /* if(head==null || head.next==null) return head;
    List<Integer> list=new ArrayList<>() ;
    ListNode temp=head;
    while(temp!=null){
        list.add(temp.val);
        temp=temp.next;
    }
Collections.sort(list);
int n=list.size();
head=new ListNode(list.get(0));
temp=head;
for(int i=1;i<n;i++){
ListNode a=new ListNode(list.get(i));
temp.next=a;
temp=temp.next;
}
return head;*/
//uding the merge sort alogorithrm
//base case
if(head==null || head.next==null) return head;
ListNode middle= findMiddle(head);
ListNode LeftHead=head;
ListNode RightHead=middle.next;
middle.next=null;
//now calling the left and right head to sort
LeftHead=sortList(LeftHead);
RightHead=sortList(RightHead);
return merge(LeftHead,RightHead);
    }
}