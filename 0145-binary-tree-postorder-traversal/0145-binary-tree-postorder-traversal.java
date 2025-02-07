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
        public void postOrder(TreeNode root,List<Integer> res) {
          if(root==null)   return ;
         postOrder(root.left,res);
        postOrder(root.right,res);
        res.add(root.val);
        }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        // postOrder(root,res);
//we will use Two stack
 if(root==null) return res;
Stack<TreeNode> st1=new Stack<>();
Stack<TreeNode> st2=new Stack<>();
st1.push(root);
while(!st1.isEmpty()){
TreeNode curr=st1.pop();
st2.push(curr);
if(curr.left!=null) 
 st1.push(curr.left);
if(curr.right!=null)
st1.push(curr.right);}
   while(!st2.isEmpty()){
 TreeNode curr=st2.pop();
  res.add(curr.val);}
            return res;
    }
}