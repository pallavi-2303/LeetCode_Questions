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
    public void RightSideView(TreeNode root,int level,List<Integer> res) {
 if(root==null) 
 return ;
 if(level==res.size()) {
 res.add(root.val);
 }
 RightSideView(root.right,level+1,res);
 RightSideView(root.left,level+1,res);
}
    public List<Integer> rightSideView(TreeNode root) {
     List<Integer> res=new ArrayList<>();
     if(root==null)   return res;
     RightSideView(root,0,res);
     return res;
    }
}