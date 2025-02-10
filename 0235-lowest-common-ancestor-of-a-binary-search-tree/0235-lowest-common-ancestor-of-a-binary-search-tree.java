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
     public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
    if(root==null || root==p || root==q) return root;
    TreeNode Left=LCA(root.left,p,q);
    TreeNode Right=LCA(root.right,p,q);
    if(Left==null) return Right;
    else if(Right==null) return Left;
    else return root;

     }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       return LCA(root,p,q); 
    }
}