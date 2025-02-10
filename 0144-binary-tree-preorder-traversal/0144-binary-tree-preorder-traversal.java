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
public void preOrder(TreeNode root,List<Integer> res) {
if(root==null)
return;
res.add(root.val);
preOrder(root.left,res);
preOrder(root.right,res);
}
    public List<Integer> preorderTraversal(TreeNode root) {
List<Integer> res=new ArrayList<>();
// preOrder(root,res);
if(root==null) return res;
// Stack<TreeNode> st=new Stack<>();
// st.push(root);
// while(!st.isEmpty()){
//  root=st.pop();
//  res.add(root.val);
//  if(root.right!=null)  st.push(root.right);
//  if(root.left!=null) st.push(root.left);
// }
// return res;
//morris traversal
//root left right
while(root!=null){
if(root.left==null){
res.add(root.val);
root=root.right;
}
else {
//if root left is not null go to right mos node and connect pointer to root so that it can return back
TreeNode prev=root.left;
while(prev.right!=null && prev.right!=root){
prev=prev.right;
}
if(prev.right==null){
//since here we are standing at the root 
res.add(root.val);
prev.right=root;
root=root.left;
}
else {
//if it is already coonected
prev.right=null;
root=root.right;
}
}
}
return res;
        
    }
}