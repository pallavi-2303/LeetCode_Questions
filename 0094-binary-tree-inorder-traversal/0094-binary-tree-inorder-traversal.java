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
   public void inOrder(TreeNode root,List<Integer> res){
        if(root==null)   {
                return ;
        }
     inOrder(root.left,res);
         res.add(root.val);
        inOrder(root.right,res);   
   }     
    public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer> res=new ArrayList<>() ;
        // inOrder(root,res);
 //Iterative solution
/*if(root==null) {
return res;}
 Stack<TreeNode> st=new Stack<>();
 while(true){
 if(root!=null) {
  st.push(root);
  root=root.left;}
  else {
  if(st.isEmpty()) break;
   TreeNode curr=st.pop();
    res.add(curr.val);
   root=curr.right;}}
      return res;*/
      List<Integer> ans=new ArrayList<>();
if(root==null){
return ans;}
TreeNode curr=root;
while(curr!=null){
//First case if curr->left is null
if(curr.left==null){
//THERE is no left part push the root and move to right part
ans.add(curr.val);
curr=curr.right;}
else {
//if curr left is not null find rightmost element of left part
TreeNode prev=curr.left;
while(prev.right!=null && prev.right!=curr){
//If prev is not null and. prev is not pointing to curr
prev=prev.right;}
if(prev.right==null){
//Connect to curr or make the thread
prev.right=curr;
curr=curr.left;}
else{
//Prev is already pointing to curr and left part is done
prev.right=null;
ans.add(curr.val);
curr=curr.right;} } }
return ans;
    }
}