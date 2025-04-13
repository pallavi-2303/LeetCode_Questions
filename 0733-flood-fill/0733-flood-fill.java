class Solution {
    public void dfs(int sr,int sc,int color,int inicolor,int[][] vis,int[][] image,int[] dr,int[] dc) {
int n=image.length;
int m=image[0].length;
vis[sr][sc]=color;
//try in 4 direction
for(int i=0;i<4;i++){
int nrow=sr+dr[i];
int ncol=sc+dc[i];
if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && vis[nrow][ncol]!=color && image[nrow][ncol]==inicolor) {
dfs(nrow,ncol,color,inicolor,vis,image,dr,dc);
}
}
}
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
       int n=image.length;
int m=image[0].length;
int[][] vis=new int[n][m];
vis=image;
int[] delrow={-1,1,0,0};
int[] delcol={0,0,-1,1};
int initialcolor=image[sr][sc];
dfs(sr,sc,color, initialcolor,vis,image,delrow,delcol);
return vis; 
    }
}