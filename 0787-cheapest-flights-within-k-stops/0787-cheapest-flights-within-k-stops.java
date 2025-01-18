class Solution {
   public class tuple{
 int first;
 int second;
 int third;
 public tuple(int first,int second,int third ){
  this.first=first;
  this.second=second;
  this.third=third;
 }
 }
 public class pair{
  int first;
  int second;
  public pair(int first,int second){
   this.first=first;
   this.second=second;
  }
 }
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
  int m=flights.length;
     ArrayList<ArrayList<pair>> adj=new ArrayList<>();
     for(int i=0;i<n;i++){
     adj.add(new ArrayList<pair>());}
   //creating an adjcaency list
   for(int i=0;i<m;i++){
   int u=flights[i][0];
   int v=flights[i][1];
   int wt=flights[i][2];
   adj.get(u).add(new pair(v,wt));
   }
   //since we are updating distance on the basis of k which 
  // will increase only by once we use queue
  Queue<tuple> q=new LinkedList<>();
  int[] dist=new int[n];
  Arrays.fill(dist,(int)(1e9));
  q.add(new tuple(0,src,0));
  dist[src]=0;
  while(!q.isEmpty()) {
  tuple it=q.poll();
  int stops=it.first;
  int node=it.second;
  int price=it.third;
  if(stops>k) continue;
  for(pair pt:adj.get(node)) {
  int adjnode=pt.first;
  int adjprice=pt.second;
  if(price+adjprice<dist[adjnode] && stops<=k){
   dist[adjnode]=price+adjprice;
   q.add(new tuple(stops+1,adjnode,dist[adjnode]));
  }
  }
  }
  if(dist[dst]==(int)(1e9)) return -1;//unreachable 
  return dist[dst];
        
    }
}