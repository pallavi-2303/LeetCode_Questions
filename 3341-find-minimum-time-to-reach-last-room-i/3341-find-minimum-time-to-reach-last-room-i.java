class Solution {
     public class tuple{
int time;
int row;
int col;
tuple(int time,int row,int col){
this.row=row;
this.col=col;
this.time=time;
}
}
    public int minTimeToReach(int[][] moveTime) {
int n=moveTime.length;
int m=moveTime[0].length;
PriorityQueue<tuple> pq=new PriorityQueue<>((x,y)->Integer.compare(x.time,y.time));
pq.add(new tuple(0,0,0));
int[][] dist=new int[n][m];
for(int[] a:dist) {
Arrays.fill(a,Integer.MAX_VALUE);
}
dist[0][0]=0;
int[] dr={-1,1,0,0};
int[] dc={0,0,-1,1};
while(!pq.isEmpty()){
tuple it=pq.poll();
int row=it.row;
int col=it.col;
int time=it.time;
 // Skip if this time is not optimal
    if (time > dist[row][col]) continue;
if(row==n-1 && col==m-1){
//it is the shortest time to reach the node 
return time;
}
for(int i=0;i<4;i++){
int nrow=row+dr[i];
int ncol=col+dc[i];
if(nrow>=0 && ncol>=0 && nrow<n && ncol<m) {
int wait=Math.max(moveTime[nrow][ncol]-time,0);
int newTime=wait+time+1;
if(dist[nrow][ncol]>newTime){
dist[nrow][ncol]=newTime;
pq.add(new tuple(newTime,nrow,ncol));
}
}
}
}
return -1;//not possible  
    }
}