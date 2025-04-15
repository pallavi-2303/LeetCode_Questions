/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return " ";
StringBuilder res=new StringBuilder();
Queue<TreeNode> q=new LinkedList<>();
q.add(root);
while(!q.isEmpty()) {
TreeNode curr=q.poll();
if(curr==null) {
res.append("n ");
}
else {
res.append(curr.val).append(" ");
q.add(curr.left);
q.add(curr.right);
}
}
return res.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

 if(data.length()==0) return null;
     String[] values=data.split(" ");
int n=values.length;
if(n==0) return null;
TreeNode root=new TreeNode(Integer.parseInt(values[0])) ;
Queue<TreeNode> q=new LinkedList<>();
q.add(root);
for(int i=1;i<n;i++){
TreeNode curr=q.poll();
if(!values[i].equals("n")) {
curr.left=new TreeNode(Integer.parseInt(values[i]));
q.add(curr.left);
}
if(++i<n && !values[i].equals("n")) {
curr.right=new TreeNode(Integer.parseInt(values[i]));
q.add(curr.right);
}
}
return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));