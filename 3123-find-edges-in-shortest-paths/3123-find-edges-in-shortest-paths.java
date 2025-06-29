class Solution {
    class pair {
        int node;
        int cost;

        pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
public void findPath(int source,List<List<pair>> adj,int[] des){
PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->Integer.compare(a.cost,b.cost));
des[source]=0;
pq.add(new pair(source,0));
while(!pq.isEmpty()){
pair it=pq.poll();
int node=it.node;
//go to its neighbours
for(pair pt:adj.get(node)){
int adjnode=pt.node;
int cost=pt.cost;
if(des[node]+cost<des[adjnode]){
des[adjnode]=des[node]+cost;
pq.add(new pair(adjnode,des[adjnode]));
}
}
}
}
    public boolean[] findAnswer(int n, int[][] edges) {
        //for this first we have to make a graph 
        List<List<pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) {
        adj.add(new ArrayList<>());
        }   
    for(int[] a:edges){
    int u=a[0];
    int v=a[1];
    int cost=a[2];
    adj.get(u).add(new pair(v,cost));
    adj.get(v).add(new pair(u,cost));
    }
 //shortest path from source to destination    
int[] srcToDes=new int[n];
Arrays.fill(srcToDes,Integer.MAX_VALUE);
findPath(0,adj,srcToDes);
//shortest path from desttination  to source
 int[] desToSrc=new int[n]; 
 Arrays.fill(desToSrc,Integer.MAX_VALUE);
 findPath(n-1,adj,desToSrc);
 //finding result lets say theres is a edges from soource to a and cost of ato b b to des if its equsls to shorstse distsnce it can be the edge beween the shortest path
int shortestDis=srcToDes[n-1];
int m=edges.length;
boolean[] result=new boolean[m];
int idx=0;
for(int[] a:edges) {
int u=a[0];
int v=a[1];
int cost=a[2];
//src to a and then a tob cost tthen b to des equal to shortsest path
if( srcToDes[u] != Integer.MAX_VALUE && desToSrc[v] != Integer.MAX_VALUE &&srcToDes[u]+cost+desToSrc[v]==shortestDis){
result[idx]=true;
}
else if( srcToDes[v] != Integer.MAX_VALUE && desToSrc[u] != Integer.MAX_VALUE &&srcToDes[v]+cost+desToSrc[u]==shortestDis){
result[idx]=true;
}
idx++;
}
return  result;
   }
}