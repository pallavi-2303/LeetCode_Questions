class Solution {
    private int mod=(int)1e9+7;
    public class pair{
    long first;
    int second;
    public pair(long first,int second){
    this.first=first;
    this.second=second;
    }
    }
    public int countPaths(int n, int[][] roads) {
     int m=roads.length;
     List<List<pair>> adj=new ArrayList<>();
     for(int i=0;i<n;i++){
      adj.add(new ArrayList<pair>()); 
     }
     for(int[] road:roads) {
int u=road[0];
int v=road[1];
long time=road[2];
adj.get(u).add(new pair((long)time,v));
adj.get(v).add(new pair((long)time,u));
     } 
int[] ways=new int[n];
long[] des=new long[n];
Arrays.fill(des,Long.MAX_VALUE);
Arrays.fill(ways,0);
PriorityQueue<pair> pq=new PriorityQueue<>((x,y)->Long.compare(x.first,y.first));
pq.offer(new pair((long)0,0));
des[0]=0;
ways[0]=1;
while(!pq.isEmpty()){
long time=pq.peek().first;
int node=pq.peek().second;
pq.poll();
//if this distance is already been updated  with shorter time
if(time>des[node]) continue;
for(pair it:adj.get(node)){
long adjtime=it.first;
int adjnode=it.second;
if(des[node]+adjtime<des[adjnode]){
des[adjnode]=des[node]+adjtime;
ways[adjnode]=ways[node];
pq.offer(new pair(des[adjnode],adjnode));
}
//if reaching on second time for shortest distance
else if(des[adjnode]==des[node]+adjtime){
ways[adjnode]=(ways[adjnode]+ways[node])%mod;
}
}
}
return ways[n-1];
    }
}