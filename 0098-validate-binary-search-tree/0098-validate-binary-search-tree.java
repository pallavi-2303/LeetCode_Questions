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
    public boolean isValidBST(TreeNode root) {
      //we know that inorder of binary search tree is always sort
if(root==null) return true;
List<Integer> temp=new ArrayList<>();
inorder(root,temp);
for(int i=1;i<temp.size();i++){
if(temp.get(i-1)>=temp.get(i)) return false;
}
return true;

    }
}