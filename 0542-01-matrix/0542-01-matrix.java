class Solution {
    public class tuple{
        int row;
        int col;
        int dis;
        public tuple(int row,int col,int dis){
            this.row=row;
            this.col=col;
            this.dis=dis;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
     int n=mat.length;
     int m=mat[0].length;
      int[] delrow={-1,1,0,0} ;
      int[] delcol={0,0,-1,1};
      int[][] vis=new int[n][m];
      int[][] distance=new int[n][m];
      Queue<tuple> q=new LinkedList<>();
      //putting in vis array whose cel is 0 0 initila configurstion
      for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
        if(mat[i][j]==0){
        q.add(new tuple(i,j,0));
        vis[i][j]=1;
        }
        else {
            vis[i][j]=0;
        }
    }
      }
      //performing the bfs aproach
      while(!q.isEmpty()){
        tuple it=q.poll();
        int row=it.row;
        int col=it.col;
        int dis=it.dis;
distance[row][col]=dis;
//traversing in four direction for calculating distance
for(int i=0;i<4;i++){
int nrow=row+delrow[i];
int ncol=col+delcol[i];
if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && mat[nrow][ncol]==1){
    vis[nrow][ncol]=1;
    q.add(new tuple(nrow,ncol,dis+1));
}
}
      }
      return distance;

    }
}