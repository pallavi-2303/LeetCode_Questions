/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
   if(root==null)  return null;
   //if  we cannot decide wheather to search on left or right then it will be our answer
   if(root.val>p.val && root.val>q.val){
    //both lie on left side
    return lowestCommonAncestor(root.left,p,q);
   }
   //both lie on right side
if(root.val<p.val && root.val<q.val){
    return lowestCommonAncestor(root.right,p,q);
}
//if we cannot decide wheather to move left or right so root is answer
return root;

    }
}