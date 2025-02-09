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
 public void countNodes2(TreeNode root,int[] count){
 if(root==null) return ;
   count[0]=count[0]+1;
   countNodes2(root.left,count);
    countNodes2(root.right,count);}
public int findLeftNodes(TreeNode root){
 root=root.left;
  int count=0;
  while(root!=null){
    count++;
    root=root.left;}
    return count;}
public int findRightNodes(TreeNode root){
  root=root.right;
  int count=0;
  while(root!=null){
    count++;
    root=root.right;}
 return count;}
    public int countNodes(TreeNode root) {
  //brute force counting all nodes
/*int[] count=new int[1];
 countNodes2(root,count);
      return count[0];*/
//we will use height property
  if(root==null) return 0;
int left=findLeftNodes(root);
int right=findRightNodes(root);
if(left==right){
return ((2<<left)-1);}
 else {
 return 1+countNodes(root.left)+countNodes(root.right);}




    }
}