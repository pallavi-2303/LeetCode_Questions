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
public int findSum(TreeNode root,int[] maxi){
if(root==null) return 0;
int left=Math.max(0,findSum(root.left,maxi));
int right=Math.max(0,findSum(root.right,maxi));
maxi[0]=Math.max(maxi[0],left+right+root.val);
return Math.max(left,right)+root.val;
}
    public int maxPathSum(TreeNode root) {
     if(root==null) return 0;
     int[] maxi={Integer.MIN_VALUE} ;
     findSum(root,maxi);
     return maxi[0];
    }
}