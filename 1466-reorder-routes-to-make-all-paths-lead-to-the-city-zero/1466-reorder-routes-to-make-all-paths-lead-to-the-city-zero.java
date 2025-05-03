class Solution {
    public class pair{
    int des;
    int val;
    pair(int des,int val){
    this.des=des;
    this.val=val;
    }
    }
    private int count=0;
    public void dfs(int node,int parent,List<List<pair>> adj){
    for(pair it:adj.get(node)){
    int v=it.des;
    if(v!=parent){
    int check=it.val;
    //it is going from 0 to oather nodes
    if(check==1){
    count+=1;//means it goinf away from 0 
    }
     dfs(v,node,adj);
    }}
    }
    public int minReorder(int n, int[][] connections) {
    //since we have to make traversal from city 0 to all we will create a extra edge that will point to value 0 and if it goes away from 0 we add 1 to answer 
    int size=connections.length;
    List<List<pair>> adj=new ArrayList<>();
    for(int i=0;i<n;i++){
    adj.add(new ArrayList<>());
    } 
//making adjcency list 
for(int i=0;i<size;i++){
int u=connections[i][0];
int v=connections[i][1];
adj.get(u).add(new pair(v,1));//original pair
adj.get(v).add(new pair(u,0));//our fake created pair to visit all the nodes
}
//we are using parent to keep track of vis nodees
dfs(0,-1,adj);
return count;
    }
}