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
    public void countGoodNodes(TreeNode root,int[] count,int maxi){
if(root==null) {
return;}
//Since we have to process the root
if(root.val>=maxi){
count[0]++;
maxi=root.val;}
countGoodNodes(root.left,count,maxi);
countGoodNodes(root.right,count,maxi);}
    public int goodNodes(TreeNode root) {
       if(root==null) return 0;
int[] count={0};
 countGoodNodes(root,count,Integer.MIN_VALUE); 
 return count[0];
    }
}