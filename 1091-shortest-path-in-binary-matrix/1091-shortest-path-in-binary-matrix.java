class Solution {
    public class tuple{
    int distance;
    int row;
    int col;
        public tuple(int distance,int row,int col){
           this.distance=distance;
            this.row=row;
            this.col=col;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
   int n=grid.length;
int m=grid[0].length;
        if(grid[0][0]==1) return -1;
        if(n==1) return 1;
int[][] dist=new int[n][m];
        for(int[] a:dist){
            Arrays.fill(a,(int)(1e9));
        }
      Queue<tuple> q=new LinkedList<>();
    q.add(new tuple(1,0,0));
    dist[0][0]=1;
    int[] delrow={-1,-1,-1,0,0,1,1,1};
    int[] delcol={-1,0,1,-1,1,-1,0,1};
    while(!q.isEmpty()){
    tuple it=q.poll();
    int distance=it.distance;
        int row=it.row;
        int col=it.col;
        //travsersing all the neighbour
        for(int i=0;i<8;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==0 && 1+distance<dist[nrow][ncol]){
             dist[nrow][ncol]=1+distance;
            q.add(new tuple(dist[nrow][ncol],nrow,ncol));
            if(nrow==n-1 && ncol==m-1) return 1+distance;
            }
        }
    }
        return -1;
    }
}