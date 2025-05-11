class Solution {
public Map<Integer,List<Integer>> buildAdjacent(int[][] edges){
int n=edges.length;
Map<Integer,List<Integer>> mp=new HashMap<>();
for(int[] a:edges){
int u=a[0];
int v=a[1];
mp.putIfAbsent(u,new ArrayList<>());
mp.putIfAbsent(v,new ArrayList<>());
mp.get(u).add(v);
mp.get(v).add(u);
}
return mp;
}
public int findDiameter(Map<Integer,List<Integer>> mp) {
List<Integer> farthestNode=BFS(mp,0);
farthestNode=BFS(mp,farthestNode.get(0));
return farthestNode.get(1);
}
public List<Integer> BFS(Map<Integer,List<Integer>> adj,int node){
Map<Integer,Boolean> visited=new HashMap<>();
Queue<Integer> q=new LinkedList<>();
int farthest=node;
int diameter=0;
q.add(node);
visited.put(node,true);
while(!q.isEmpty()){
int n=q.size();
for(int i=0;i<n;i++){
int curr=q.poll();
farthest=curr;
//visiting the current node neighbour 
for(int it:adj.getOrDefault(curr,new ArrayList<>())){
if(!visited.getOrDefault(it,false)){
visited.put(it,true);
q.add(it);
}
}
}
if(q.size()!=0) diameter++;
}
return Arrays.asList(farthest,diameter);
}

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
     //if the diamter is very larger and found in nly one graph it cannot be connected in another and if it can be found by adjing two grraph it is calcultaed using diveing the current find mid of both diamter and adding one to iit 
    //step -1 create the adjacency matrix
Map<Integer,List<Integer>> adj1=buildAdjacent(edges1);
Map<Integer,List<Integer>> adj2=buildAdjacent(edges2);
int d1=findDiameter(adj1);
int d2=findDiameter(adj2);
int combine=((d1+1)/2)+((d2+1)/2)+1;
return Math.max(d1,Math.max(d2,combine));

    }
}