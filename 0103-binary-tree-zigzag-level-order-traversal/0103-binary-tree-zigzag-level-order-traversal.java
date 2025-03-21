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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      List<List<Integer>> ans=new ArrayList<>() ;
      if(root==null) return ans;
      Queue<TreeNode> q=new LinkedList<>();
      boolean isleftToRight=true;
      q.add(root);
      while(!q.isEmpty()){
     int size=q.size();
     List<Integer> temp=new ArrayList<>();
     for(int i=1;i<=size;i++) {
        TreeNode curr=q.poll();
temp.add(curr.val);
if(curr.left!=null) q.add(curr.left);
if(curr.right!=null) q.add(curr.right);
     } 
    if(isleftToRight==true) ans.add(temp);
    else {
    Collections.reverse(temp);
    ans.add(temp);
    }
    isleftToRight=!isleftToRight;
      }
      return ans;
    }
}