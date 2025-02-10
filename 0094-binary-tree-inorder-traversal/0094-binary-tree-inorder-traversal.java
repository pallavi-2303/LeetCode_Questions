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
      public void inOrder(TreeNode root,List<Integer> res) {
if(root==null) return;
inOrder(root.left,res);
res.add(root.val);
inOrder(root.right,res);
}
    public List<Integer> inorderTraversal(TreeNode root) {
List<Integer> res=new ArrayList<>();
if(root==null) return res;
// inOrder(root,res);
//Interative aproach
// Stack<TreeNode> st=new Stack<>();
// while(true){
// if(root!=null) {
// st.push(root);
// root=root.left;
// }  
// else {
// if(st.isEmpty()) break;
// TreeNode curr=st.pop();
// res.add(curr.val);
// root=curr.right;
// } 
// }
//Morris Traversal so there are two case if root->left is null or if it not null 
while(root!=null){
//left root and right
if(root.left==null){
res.add(root.val);
//move to right side
root=root.right;
}
else {
//go to right most guy of left part and coonect the theread  it also has two caes
TreeNode prev=root.left;
while(prev.right!=null && prev.right!=root){
prev=prev.right;
}
//case 1 if prev right is null
if(prev.right==null){
prev.right=root;
root=root.left;
}
else {
//it is the place we have travsered the left aprt we have come to root node via right pointer 
prev.right=null;
res.add(root.val);
root=root.right;
}
}
}
return res;
    }
}