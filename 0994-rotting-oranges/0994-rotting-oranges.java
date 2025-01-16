class Solution {
    public class tuple{
        int row;
        int col;
        int tm;
        public tuple(int row,int col,int tm){
            this.row=row;
            this.col=col;
            this.tm=tm;
        }
    }
    public int orangesRotting(int[][] grid) {
    //since we have to move four dirctionaly we will use bfs as it one unit of time it will rot its adjacent neighbour 
  int n=grid.length;
  int m=grid[0].length;  
  int[][] vis=new int[n][m] ;
  Queue<tuple> q=new LinkedList<>(); 
  //insert the values that are rotten 
  int countfresh=0;
  for(int i=0;i<n;i++){
for(int j=0;j<m;j++){
if(grid[i][j]==2){
//means it is rotten 
vis[i][j]=1;
q.add(new tuple(i,j,0));
}
else {
vis[i][j]=0;
}
if(grid[i][j]==1) countfresh++;
}
  }
  //performing the bfs traversal and finding out the time to rot all the oranges
  int time=0;
  int cnt=0;
  int[] delrow={-1,1,0,0};
  int[] delcol={0,0,-1,1};
  while(!q.isEmpty()){
tuple it=q.poll();
int row=it.row;
int col=it.col;
int tm=it.tm;
time=Math.max(time,tm);
//traversing in all the four direction
for(int i=0;i<4;i++){
int nrow=row+delrow[i];
int ncol=col+delcol[i];
//conditional check
if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && vis[nrow][ncol]==0){
//it is fresh orange and it can be rotten
cnt++;
vis[nrow][ncol]=1;
q.add(new tuple(nrow,ncol,tm+1));
}
}
  }
  return cnt>= countfresh ?  time : -1;
    }
}