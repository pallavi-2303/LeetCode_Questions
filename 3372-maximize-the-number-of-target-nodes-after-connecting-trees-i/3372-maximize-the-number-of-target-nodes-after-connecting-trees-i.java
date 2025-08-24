class Solution {
    public List<List<Integer>> makeGraph(int[][] edges) {
        int N = edges.length + 1;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] a : edges) {
            int u = a[0];
            int v = a[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }
public int dfs(int node, List<List<Integer>> adj,int k,int[] vis){
if(k<0) return 0;
int count=1;
vis[node]=1;
for(int it:adj.get(node)){
if(vis[it]==0){
count+=dfs(it,adj,k-1,vis);
}
}
return count;
}
public int[] findNodes( List<List<Integer>> adj,int k){
int n=adj.size();
int[] result=new int[n];
for(int i=0;i<n;i++){
int[] vis=new int[n];
result[i]=dfs(i,adj,k,vis);
}
return result;
}
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        //we will find out the count of nodes that are at distance of k from tree A and and find number of nodes that are at distance of k-1 from tree 2 as one node will go from connecting the node fron tree 1 and tree2 and the node wich give max we will connect with onky that node
    int n1=edges1.length+1;
    int n2=edges2.length+1;
        List<List<Integer>> adj1 = makeGraph(edges1);
        List<List<Integer>> adj2 = makeGraph(edges2);
    int [] result1=findNodes(adj1,k);
    int[] result2=findNodes(adj2,k-1);
    int maxEle=Arrays.stream(result2).max().getAsInt();
    for(int i=0;i<n1;i++){
    result1[i]+=maxEle;
    }
return result1;
    }
}