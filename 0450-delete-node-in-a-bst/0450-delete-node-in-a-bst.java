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
    public TreeNode Helper(TreeNode root) {
//it is the node to be deleted 
if(root.left==null) {
return root.right;
}
else if(root.right==null) {
return root.left;
}
//if both are not null
TreeNode rightChild=root.right;
TreeNode rightMostEle=findRight(root.left);
rightMostEle.right=rightChild;
return root.left;
}
public TreeNode findRight(TreeNode root) {
 if(root.right==null) return root;
 return findRight(root.right);
}
    public TreeNode deleteNode(TreeNode root, int key) {
        //if root itself is the node to be deleted
if( root!=null && root.val==key) {
return Helper(root);
}
TreeNode dummy=root;
//if the middle or left or right has to be deleted so to dekete we have to come to a value previous to that node
while(root!=null) {
if(root.val>key) {
//to the key to be deleted is in left part
if(root.left!=null && root.left.val==key) {
root.left=Helper(root.left);
break;
}
else {
root=root.left;
}
}
else {
if(root.right!=null && root.right.val==key) {
root.right=Helper(root.right);
break;}
else {
root=root.right;
}
} }
return dummy;
    }
}