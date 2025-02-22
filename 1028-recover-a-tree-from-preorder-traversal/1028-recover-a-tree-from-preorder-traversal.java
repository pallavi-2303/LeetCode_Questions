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

    public TreeNode recoverFromPreorder(String s) {
     int n=s.length() ;
     int index=0;
        Stack<TreeNode> st=new Stack<>();
while(index<n){
//counting the dash 
int count=0;
while(index<n && !Character.isDigit(s.charAt(index))) {
index++;
count++;}
int depth=st.size();
while(depth>count){
st.pop();
depth--;}
//finding the value
int val=0;
while(index<n && Character.isDigit(s.charAt(index))){
val=val*10+(s.charAt(index)-'0');
index++;}
TreeNode node=new TreeNode(val);
if(!st.isEmpty()){
if(st.peek().left==null){
st.peek().left=node;}
else {
st.peek().right=node;}}
st.push(node);}
while(st.size()>1) st.pop();
return st.peek();
    }
}