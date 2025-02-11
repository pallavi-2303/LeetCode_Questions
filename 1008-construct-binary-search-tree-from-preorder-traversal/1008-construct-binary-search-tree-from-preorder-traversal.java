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
    public TreeNode bstFromPreOrder(int[] preorder,int bound,int[] i){
        if(i[0]==preorder.length || preorder[i[0]]>bound) {
            return null;
        }
        //in preorder first value is root
        TreeNode root=new TreeNode(preorder[i[0]++]);
        //for left root-> val will be upper bound
        root.left=bstFromPreOrder(preorder,root.val,i);
        //for right root upper bound will be itst upper bound
        root.right=bstFromPreOrder(preorder,bound,i);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
     //optimal solution can be caring the bound
     return bstFromPreOrder(preorder,Integer.MAX_VALUE,new int[]{0});
    }
}