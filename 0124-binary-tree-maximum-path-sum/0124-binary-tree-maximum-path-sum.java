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
public int pathSum(TreeNode root,int[] sum){
if(root==null) return 0;
  //if at any point sum become negative
int left=Math.max(0,pathSum(root.left,sum));
int right=Math.max(0,pathSum(root.right,sum));
//sum can pass through root or it can be left or right we have to take max of all
sum[0]=Math.max(sum[0],left+right+root.val);
//as there is negative value also 
return root.val+Math.max(left,right);}
    public int maxPathSum(TreeNode root) {
int[] sum={Integer.MIN_VALUE};
  pathSum(root,sum);
      return sum[0];
    }
}