class Solution {
    public void dfs(int row,int col,int[][] image,int[][] vis,int color,int inicolor,int[] delrow,int[] delcol){
        int n=image.length;
    int m=image[0].length;
        vis[row][col]=color;//coloring it with given color
//moving in four direction
for(int i=0;i<4;i++){
int nrow=row+delrow[i];
int ncol=col+delcol[i];
//checking all the condition
if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]!=color && image[nrow][ncol]==inicolor){
    dfs(nrow,ncol,image,vis,color,inicolor,delrow,delcol);
}
} 
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    //in thhis we can use bfs and dfs both to color the image
    int n=image.length;
    int m=image[0].length;
    int[][] vis=new int[n][m];
    vis=image;
    int inicolor=image[sr][sc];
    int[] delrow={-1,1,0,0} ;
    int[] delcol={0,0,-1,1};
    dfs(sr,sc,image,vis,color,inicolor,delrow,delcol);
    return vis;
    }
}