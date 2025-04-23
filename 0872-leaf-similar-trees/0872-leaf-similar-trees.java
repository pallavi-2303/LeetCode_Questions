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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
       Stack<TreeNode> st1=new Stack<>();
Stack<TreeNode> st2=new Stack<>();
st1.push(root1);
st2.push(root2);
while(!st1.isEmpty() && !st2.isEmpty()){
if(dfs(st1)!=dfs(st2)){
return false;}
}
return st1.isEmpty() && st2.isEmpty(); 
    }
    public int dfs(Stack<TreeNode> st){
while(true){
TreeNode node=st.pop();
if(node.right!=null) st.push(node.right);
if(node.left!=null)
st.push(node.left);
if(node.left==null && node.right==null)
return node.val;}}
}