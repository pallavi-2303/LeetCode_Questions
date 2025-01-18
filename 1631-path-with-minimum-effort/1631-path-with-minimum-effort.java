class Solution {
  public static class tuple{
     int diff;
     int row;
     int col;
     public tuple(int diff,int row,int col){
      this.diff=diff;
      this.row=row;
      this.col=col;
     }
    }
    public int minimumEffortPath(int[][] heights) {
      //after exploring all the path and finding max effort out of all 
     //we have to return the minimum effort
     //using priority Queue
     int n=heights.length;
     int m=heights[0].length;
    int[][] dist=new int[n][m];
   for(int[] a:dist){
    Arrays.fill(a,(int)(1e9));}
  PriorityQueue<tuple> pq=new PriorityQueue<tuple>((x,y)->x.diff-y.diff);
  int[] delrow={-1,1,0,0};
  int[] delcol={0,0,-1,1};
  pq.add(new tuple(0,0,0));
  dist[0][0]=0;
  //performing the dikstras
  while(!pq.isEmpty()) {
  tuple it=pq.peek();
  pq.remove();
  int diff=it.diff;
  int row=it.row;
  int col=it.col;
 //if some diff is come out of queue means it is minimum 
 if(row==n-1 && col==m-1){
  return diff;// Minimum effort
 }
for(int i=0;i<4;i++) {
int nrow=row+delrow[i];
int ncol=col+delcol[i];
if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
int newEffort=Math.max(Math.abs(heights[nrow][ncol]-heights[row][col]),diff);
if(newEffort<dist[nrow][ncol]){
 dist[nrow][ncol]=newEffort;
 pq.add(new tuple(newEffort,nrow,ncol));
} }}}
return 0;//not reachable 
        
    }
}