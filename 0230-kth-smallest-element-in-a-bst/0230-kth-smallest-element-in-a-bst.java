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
    public void inorder(TreeNode root,List<Integer> temp) {
if(root==null) return;
inorder(root.left,temp);
temp.add(root.val);
inorder(root.right,temp);
}
    public int kthSmallest(TreeNode root, int k) {
        //we know that inorder of binary search tree is always sort
List<Integer> temp=new ArrayList<>();
inorder(root,temp);
return temp.get(k-1);
    }
}