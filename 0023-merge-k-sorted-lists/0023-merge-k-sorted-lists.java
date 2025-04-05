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
    //brute  force
    if(lists.length==0) return null;
  List<Integer> arr=new ArrayList<>();
  for(ListNode head:lists){
ListNode temp=head;
while(temp!=null){
arr.add(temp.val);
temp=temp.next;
}
  }  
Collections.sort(arr);
if(arr.size()==0) return null;
ListNode root=new ListNode(arr.get(0));
ListNode  temp=root;
for(int i=1;i<arr.size();i++){
ListNode a=new ListNode(arr.get(i));
temp.next=a;
temp=temp.next;
}
return root;  
    }
}