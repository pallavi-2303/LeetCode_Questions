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
    public int findHeight1(TreeNode root){
    int count=0;
    while(root!=null){
        count++;
        root=root.left;
    }
    return count;
    }
    public int findHeight2(TreeNode root){
        int count=0;
        while(root!=null){
            count++;
            root=root.right;
        }
        return count;
    }
    //private int count=0;
    public int countNodes(TreeNode root) {
     //brute force
   /*  if(root==null) return 0;
     count++;
     countNodes(root.left);
     countNodes(root.right);
     return count;*/
    //if at any point the height of the tree are equal we can use the formula .. and to find the left and right hright the current node is also included
 if(root==null) return 0;
 int left=findHeight1(root) ;
 int right=findHeight2(root) ;
 if(left==right){
  return ((1<<left)-1);
 }

    //calculate the left and right height at each point by going to its left and right
 else return 1+countNodes(root.left)+countNodes(root.right);
 

    }
}