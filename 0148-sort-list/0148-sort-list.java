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
   
    public ListNode sortList(ListNode head) {
    //brute force putting in aaray amd sorting it and then converting in lined list
   if(head==null || head.next==null) return head;
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
return head;
    }
}