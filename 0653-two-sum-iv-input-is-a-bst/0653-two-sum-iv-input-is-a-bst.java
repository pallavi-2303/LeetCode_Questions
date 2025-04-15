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
    public void inorder(TreeNode root,List<Integer> arr){
if(root==null) return;
inorder(root.left,arr);
arr.add(root.val);
inorder(root.right,arr);
}
    public boolean findTarget(TreeNode root, int k) {
List<Integer> ans=new ArrayList<>();
inorder(root,ans);
      int i=0;
int j=ans.size()-1;
while(i<j) {
int sum=ans.get(i)+ans.get(j);
if(sum==k) return true;
if(sum<k) i++;
else j--;
}
return false;  
    }
}