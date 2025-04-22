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
    public int pairSum(ListNode head) {
       int size=0;
if(head==null) return 0;
ListNode temp=head;
while(temp!=null){
temp=temp.next;
size++;}
int[] arr=new int[size];
int idx=0;
temp=head;
while(temp!=null){
arr[idx]=temp.val;
temp=temp.next;
idx++;}
int i=0;
int j=size-1;
int maxi=0;
while(i<j){
int sum=arr[i]+arr[j];
maxi=Math.max(sum,maxi);
i++;
j--;}
return maxi; 
    }
}