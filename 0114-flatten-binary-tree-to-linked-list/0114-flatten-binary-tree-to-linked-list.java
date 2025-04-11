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
    TreeNode prev=null;
    public void flatten(TreeNode root) {
     //recurrsive code by post order traversal
// if(root==null) return ;
// flatten(root.right);
// flatten(root.left);
// //do operation on node
// root.right=prev;
// root.left=null;
// prev=root;
//recurrsive traversal of morris traversal
while(root!=null){
if(root.left!=null){
TreeNode prev=root.left;
//go to rightmost guy
 while(prev.right!=null)  {
prev=prev.right;
 }
 prev.right=root.right;
 root.right=root.left;
 root.left=null;
}
//move previous to left 
root=root.right;}
    }
}