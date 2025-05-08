class Solution {
    public class tuple{
int time;
int row;
int col;
tuple(int time,int row,int col){
this.time=time;
this.row=row;
this.col=col;}}
    public int minTimeToReach(int[][] moveTime) {
int n=moveTime.length;
int m=moveTime[0].length;
PriorityQueue<tuple> pq=new PriorityQueue<>((x,y)->Integer.compare(x.time,y.time));
pq.add(new tuple(0,0,0));
int[][] dist=new int[n][m];
for(int[] a:dist){
Arrays.fill(a,Integer.MAX_VALUE);}
dist[0][0]=0;
int[] dr={-1,1,0,0};
int[] dc={0,0,-1,1};
while(!pq.isEmpty()){
tuple it=pq.poll();
int time=it.time;
int row=it.row;
int col=it.col;
//Since the time is come out of diskstarast it would be the shortest time to reach the last node throught all its neighbours
if(row==n-1 && col==m-1){
return time;}
for(int i=0;i<4;i++){
int nrow=row+dr[i];
int ncol=col+dc[i];
if(nrow>=0 && ncol>=0 && nrow<n && ncol<m) {
int moveCost=(nrow+ncol)%2==0 ? 2 : 1;
int waitTime=Math.max(0,moveTime[nrow][ncol]-time);
int arrTime=time+waitTime+moveCost;
if(dist[nrow][ncol]>arrTime){
dist[nrow][ncol]=arrTime;
pq.add(new tuple(arrTime,nrow,ncol));
}
} }}
return -1;   
    }
}