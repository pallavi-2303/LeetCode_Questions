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
    public void rightView(TreeNode root,List<Integer> ds,int level){
if(root==null) return;
if(ds.size()==level){
ds.add(root.val);}
rightView(root.right,ds,level+1);
rightView(root.left,ds,level+1);}
    public List<Integer> rightSideView(TreeNode root) {
     if(root==null)  return new ArrayList<>();
     List<Integer> ds=new  ArrayList<>();
     rightView(root,ds,0);
     return ds;
    }
}