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
 //So in Bst Iterator we generally need to do the inorder traversal
class BSTIterator {
Stack<TreeNode> st=new Stack<>();
    public BSTIterator(TreeNode root) {
      //start the inorder traversal from here 
      pushAll(root);  
    }
    
    public int next() {
     //it will give the first node of the inorder
     TreeNode temp=st.pop();
     //push all right of it 
     pushAll(temp.right);
     return temp.val;  
    }
    
    public boolean hasNext() {
       return !st.isEmpty(); 
    }
    public void pushAll(TreeNode root){
    while(root!=null){
    st.push(root);
    root=root.left;
    }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */