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
    public void inorder(TreeNode root,List<Integer> ans){
    if(root==null) return;
    inorder(root.left,ans);
    ans.add(root.val);
    inorder(root.right,ans);
    }
    public int getMinimumDifference(TreeNode root) {
     //so the minimum abosulte fiffrence will ve between tthe first and second smallest number  
     List<Integer> ans=new ArrayList<>();
     if(root==null) return 0;
    inorder(root,ans);
    int mini=Integer.MAX_VALUE;
    for(int i=1;i<ans.size();i++){
    mini=Math.min(mini,ans.get(i)-ans.get(i-1));    
    }
    return mini;
    }
}