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
    public TreeNode insertIntoBST(TreeNode root, int val) {
      //find the position where to insert it and then insert it
      if(root==null)  return new TreeNode(val);
      TreeNode curr=root;
      while(true){
    if(curr.val<=val){
    //means it should be on the right side
    if(curr.right!=null) {
    curr=curr.right;
    }
    else {
    //if it should be on right but the right is null 
    curr.right=new TreeNode(val);
    break;
    }
    }
    else {
    //if should be on the left
    if(curr.left!=null){
        curr=curr.left;
    }
    else {
    curr.left=new TreeNode(val);
    break;
    }
    }
      }
      return root;

    }
}