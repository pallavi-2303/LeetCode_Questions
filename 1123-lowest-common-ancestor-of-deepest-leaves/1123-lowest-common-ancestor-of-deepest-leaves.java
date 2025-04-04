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
 private HashMap<Integer,Integer> mp=new HashMap<>();
 private int maxDepth=0;
 private int depth=0;
 public void findDepth(TreeNode root,int depth){
if(root==null){
return;
}
maxDepth=Math.max(maxDepth,depth);
mp.put(root.val,depth);
findDepth(root.left,depth+1);
findDepth(root.right,depth+1);
 }
 public TreeNode lca(TreeNode root){
if(root==null || mp.get(root.val)==maxDepth){
return root;
}
TreeNode left=lca(root.left);
TreeNode right=lca(root.right);
if(left!=null && right!=null) {
return root;
}
return left!=null ? left :right;
 }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
      findDepth(root,depth);
      return lca(root);
    }
}