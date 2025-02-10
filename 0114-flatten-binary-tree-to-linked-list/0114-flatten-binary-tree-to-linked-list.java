/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
public TreeNode prev=null;
    public void flatten(TreeNode root) {
  /* if(root==null)
     return;
  flatten(root.right);
  flatten(root.left);
   root.right=prev;
    root.left=null;
    prev=root;*/
 TreeNode curr=root;
  while(curr!=null){
 if(curr.left!=null){
 //if curr left is not null 
 TreeNode prev=curr.left;
  //move to right most element and connect to cuur right
while(prev.right!=null){
  prev=prev.right;}
  //coonect to cuurent right
   prev.right=curr.right;
   //cuurent right wiil be cuurnt left part
    curr.right=curr.left;
    curr.left=null;
   }
   //move current
   curr=curr.right;}
    }
}