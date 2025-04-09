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
    public int Height(TreeNode root){
if(root==null){
return 0;}
int left=Height(root.left);
int right=Height(root.right);
return Math.max(left,right)+root.val;}
    public int sum(TreeNode root){
if(root==null){
return 0;}
int currSum=Height(root.left)+Height(root.right)+root.val;
int left=sum(root.left);
int right=sum(root.right);
return Math.max(currSum,Math.max(left,right));}
public int sum2(TreeNode root,int[] max){
if(root==null){
return 0;}
int left=Math.max(0,sum2(root.left,max));
int right=Math.max(0,sum2(root.right,max));
max[0]=Math.max(max[0],left+right+root.val);
return Math.max(left,right)+root.val;}
    public int maxPathSum(TreeNode root) {
     int[] maxi={Integer.MIN_VALUE};
 sum2(root,maxi);
return maxi[0];   
    }
}