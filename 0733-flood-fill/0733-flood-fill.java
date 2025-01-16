class Solution {
public class pair {
 int row;
 int col;
  public pair(int row,int col){
 this.row=row;
 this.col=col;
  }}
 public void floodFillByBfs(int sr,int sc,int[][] vis,int inicolor,int color,int[] delrow,int[] delcol,int[][] image){
 int n=image.length;
 int m=image[0].length;
Queue<pair> q=new LinkedList<>();
q.add(new pair(sr,sc));
vis[sr][sc]=color;
 while(!q.isEmpty()){
pair it=q.poll();
int row=it.row;
int col=it.col;
//reaching the nighbour
 for(int i=0;i<4;i++){
 int nrow=row+delrow[i];
 int ncol=col+delcol[i];
 if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && image[nrow][ncol]==inicolor && vis[nrow][ncol]!=color){
 vis[nrow][ncol]=color;
q.add(new pair(nrow,ncol));}}}
 }
public void floodFillByDfs(int row,int col,int[][] vis,int inicolor,int color,int[] delrow,int[] delcol,int[][] image){
//mark the visited with color
int n=image.length;
int m=image[0].length;
 vis[row][col]=color;
 //traversing the neighbour
 for(int i=0;i<4;i++){
 int nrow=row+delrow[i];
int ncol=col+delcol[i];
 if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && image[nrow][ncol]==inicolor && vis[nrow][ncol]!=color){
floodFillByDfs(nrow,ncol,vis,inicolor,color,delrow,delcol,image);}}
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
  int n=image.length;
  int m=image[0].length;
int[] delrow={-1,1,0,0};
int[] delcol={0,0,-1,1};
int[][] vis=image;
int inicolor=image[sr][sc];
 /*floodFillByDfs(sr,sc,vis,inicolor,color,delrow,delcol,image);*/
  floodFillByBfs(sr,sc,vis,inicolor,color,delrow,delcol,image);
   return vis;
     
     
     
    }
}