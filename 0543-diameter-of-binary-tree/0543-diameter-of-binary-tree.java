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
public int Diameter2(TreeNode root,int[] diam){
  if(root==null) return 0;
int leftHeight=Diameter2(root.left,diam);
int rightHeight=Diameter2(root.right,diam);
//we are tracking max diameter at each point by finding the height
diam[0]=Math.max(diam[0],leftHeight+rightHeight);
return 1+Math.max(leftHeight,rightHeight);}
public int Height(TreeNode root){
if(root==null) return 0;
int left=Height(root.left);
int right=Height(root.right);
return 1+Math.max(left,right);}
 public int Diameter(TreeNode root){
if(root==null) return 0;
//max of curr diaameter left diameter and right diameter 
//curr->left height+right height 
int currDiam=Height(root.left)+Height(root.right);
int leftDiam=Diameter(root.left);
int rightDiam=Diameter(root.right);
 return Math.max(currDiam,Math.max(leftDiam,rightDiam));}
    public int diameterOfBinaryTree(TreeNode root) {
 if(root==null) return 0;
// return Diameter(root);
int[] diam=new int[1];
   Diameter2(root,diam);
    return diam[0];
   
    }
}