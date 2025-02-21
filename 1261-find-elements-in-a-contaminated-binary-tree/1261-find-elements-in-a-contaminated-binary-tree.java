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
class FindElements {
HashSet<Integer> st;
    public FindElements(TreeNode root) {
    st=new HashSet();
    //this is the step of constructing the root
      dfs(root,0);  
    }
    
    public boolean find(int target) {
       return st.contains(target);
    }
public void dfs(TreeNode root,int val){
if(root==null) return;
//we will traverse array by preorder traversal
root.val=val;
st.add(val);
dfs(root.left,2*val+1);
dfs(root.right,2*val+2);
}
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */