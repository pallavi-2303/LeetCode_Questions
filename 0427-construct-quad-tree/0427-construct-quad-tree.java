/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public boolean isSame(int[][] grid,int x,int y,int n){
    int val=grid[x][y];
    for(int i=x;i<x+n;i++){
    for(int j=y;j<y+n;j++){
    if(grid[i][j]!=val) return false;
    }
    }
    return true;
    }
    public Node solve(int[][] grid,int x,int y,int n){
   //check if the all the grid vallue is same or not
   if(isSame(grid,x,y,n)) {
return new Node(grid[x][y]==1 ? true : false,true);
   }
   else  {
//if all the values are not same
Node root=new Node(true,false);
root.topLeft=solve(grid,x,y,n/2);
root.topRight=solve(grid,x,y+n/2,n/2);
root.bottomLeft=solve(grid,x+n/2,y,n/2);
root.bottomRight=solve(grid,x+n/2,y+n/2,n/2);
return root;
   }
    }
    public Node construct(int[][] grid) {
    int n=grid.length;
    return solve(grid,0,0,n);    
    }
}