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
 public TreeNode buildTree2(int[] inorder,int inSt,int inEnd,int[] postorder,int postSt,int postEnd,HashMap<Integer,Integer> mp){
if(inSt>inEnd || postSt>postEnd)
return null;
TreeNode root=new TreeNode(postorder[postEnd]);
//inidx of root in inorder
int inRootIdx=mp.get(root.val);
//number of elements that shouold be on left of root
int left=inRootIdx-inSt;
root.left=buildTree2(inorder,inSt,inRootIdx-1,postorder,postSt,postSt+left-1,mp);
root.right=buildTree2(inorder,inRootIdx+1,inEnd,postorder,postSt+left,postEnd-1,mp);
   return root;}
    public TreeNode buildTree(int[] inorder, int[] postorder) {
 if(inorder.length!=postorder.length){
   return null;}
HashMap<Integer,Integer> mp=new HashMap<>();
 int n=inorder.length;
 for(int i=0;i<n;i++){
mp.put(inorder[i],i);}
return buildTree2(inorder,0,inorder.length-1,postorder,0,postorder.length-1,mp);
    }
}