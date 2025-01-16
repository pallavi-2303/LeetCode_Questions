class Solution {
    public class pair{
        int row;
        int col;
        public pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public void bfs(int i,int j,int[][] image,int[][] vis,int color,int inicolor,int[] delrow,int[] delcol){
          int n=image.length;
    int m=image[0].length;
    Queue<pair> q=new LinkedList<>();
    q.add(new pair(i,j));
    vis[i][j]=color;
    while(!q.isEmpty()){
    pair it=q.poll();
    int row=it.row;
    int col=it.col;
    //traversing the 4 neighbour
    for(int idx=0;idx<4;idx++) {
    int nrow=row+delrow[idx];
    int ncol=col+delcol[idx];
    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]!=color && image[nrow][ncol]==inicolor){
    vis[nrow][ncol]=color;
    q.add(new pair(nrow,ncol));
    }
    }  
    }
    }
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
   // dfs(sr,sc,image,vis,color,inicolor,delrow,delcol);
   //now the bfs approach
   bfs(sr,sc,image,vis,color,inicolor,delrow,delcol);
    return vis;
    }
}