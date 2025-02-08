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
    public boolean isSymmetric2(TreeNode Left,TreeNode Right) {
if(Left==null || Right==null)
return Left==Right;
return Left.val==Right.val && isSymmetric2(Left.left,Right.right) && isSymmetric2(Left.right,Right.left);
}
    public boolean isSymmetric(TreeNode root) {
       return root==null || isSymmetric2(root.left,root.right);
    }
}