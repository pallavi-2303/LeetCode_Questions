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
        public void preOrder(TreeNode root,List<Integer> res){
                if(root==null){
                        return;
                }
                //root left right
                res.add(root.val);
                preOrder(root.left,res);
                preOrder(root.right,res);
        }
    public List<Integer> preorderTraversal(TreeNode root) {
List<Integer> res=new ArrayList<>() ;
            //preOrder(root,res);
 //Iterative solution
/*Stack<TreeNode> st=new Stack<>();
 if(root==null) return res;
 st.add(root);
while(!st.isEmpty()){
TreeNode curr=st.pop();
res.add(curr.val);
if(curr.right!=null) 
 st.push(curr.right);
if(curr.left!=null)
 st.push(curr.left);}*/
if(root==null) return res;
 TreeNode curr=root;
     while(curr!=null){
   //if curr left is null
    if(curr.left==null){
    res.add(curr.val);
    curr=curr.right;}
    else {
 TreeNode prev=curr.left;
  //move to last element on right
 while(prev.right!=null && prev.right!=curr){
 prev=prev.right;}
if(prev.right==null){
res.add(curr.val);
 prev.right=curr;
  curr=curr.left;}
 else {
  //if prev right point to curr
  prev.right=null;
  curr=curr.right;}}}
            return res;
    }
}