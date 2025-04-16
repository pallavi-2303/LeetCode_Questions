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
private int max=0;
    public class NodeValue{
int maxValue;
int minValue;
int maxSum;
public NodeValue(int maxValue,int minValue,int maxSum){
this.maxValue=maxValue;
this.minValue=minValue;
this.maxSum=maxSum;
}
}
public NodeValue findLargestSum (TreeNode root){
if(root==null) {
//it will always be valid pass min as maximum and maxi as minimum as it is always compared 
return new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE,0);
}
NodeValue left=findLargestSum(root.left);
NodeValue right=findLargestSum(root.right);
//if we are standing at root and it is a valid bst
if(root.val>left.maxValue && root.val<right.minValue) {
int currSum=left.maxSum+right.maxSum+root.val;
max=Math.max(max,currSum);
return new NodeValue(Math.max(root.val,right.maxValue),Math.min(root.val,left.minValue),currSum);
}
else{
//if it is not a valid bst pass max as maximum and minimum as minimum such that it can't be compared
return new NodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE,Math.max(left.maxSum,right.maxSum));
}
}
    public int maxSumBST(TreeNode root) {
     max=0;
     findLargestSum(root);
     return max;
    }
}