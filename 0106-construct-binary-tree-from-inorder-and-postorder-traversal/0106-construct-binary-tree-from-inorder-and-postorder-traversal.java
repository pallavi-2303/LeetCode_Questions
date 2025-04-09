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
    public TreeNode inOrder(int is,int ie,int[] inorder,int ps,int pe,int[] postorder,HashMap<Integer,Integer> mp){
if(is>ie || ps>ps) 
return null;
TreeNode root=new TreeNode(postorder[pe]);
int inrootIdx=mp.get(root.val);
int left=inrootIdx-is;
root.left=inOrder(is,inrootIdx-1,inorder,ps,ps+left-1,postorder,mp);
root.right=inOrder(inrootIdx+1,ie,inorder,ps+left,pe-1,postorder,mp);
return root;}
    public TreeNode buildTree(int[] inorder, int[] postorder) {
     HashMap<Integer,Integer> mp=new HashMap<>();
int n=inorder.length;
for(int i=0;i<n;i++){
mp.put(inorder[i],i);}
return inOrder(0,n-1,inorder,0,n-1,postorder,mp);   
    }
}