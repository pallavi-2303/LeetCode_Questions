class Solution {
    public static class DisjointSet{
List<Integer> parent;
List<Integer> size;
List<Integer> rank;
public DisjointSet(int n) {
parent=new ArrayList<>();
size=new ArrayList<>();
rank=new ArrayList<>();
for(int i=0;i<=n;i++){
parent.add(i);
size.add(1);
rank.add(0);}}
public int findulpar(int node) {
if(parent.get(node)==node) 
return node;
int ulp=findulpar(parent.get(node));
parent.set(node,ulp);
return parent.get(node);
}
public void unionbysize(int u,int v) {
int ulp_u=findulpar(u);
int ulp_v=findulpar(v);
if(ulp_u==ulp_v) return;
if(size.get(ulp_u)>=size.get(ulp_v)) {
parent.set(ulp_v,ulp_u);
size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));}
else {
parent.set(ulp_u,ulp_v);
size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
}}
public void unionbyrank(int u,int v){
int ulp_u=findulpar(u);
int ulp_v=findulpar(v);
if(ulp_u==ulp_v) return;
if(rank.get(ulp_u)<rank.get(ulp_v)){
parent.set(ulp_u,ulp_v);}
else if(rank.get(ulp_v)<rank.get(ulp_u)){
parent.set(ulp_v,ulp_u);}
else {
parent.set(ulp_v,ulp_u);
int ranku=rank.get(ulp_u);
rank.set(ranku,ranku+1);}}
}
    public int countCompleteComponents(int n, int[][] edges) {
      DisjointSet ds=new DisjointSet(n);
for(int[] edge:edges){
ds.unionbysize(edge[0], edge[1]);}
HashMap<Integer,Integer> mp=new HashMap<>(); 
//calculating the number of edges 
for(int[] edge:edges) {
int root=ds.findulpar(edge[0]);
mp.put(root,mp.getOrDefault(root,0)+1);
}
int complete=0;
//traversing each Node
for(int node=0;node<n;node++){
if(ds.findulpar(node)==node) {
int countNode=ds.size.get(node);
int reqcount=(countNode*(countNode-1))/2;
if(reqcount==mp.getOrDefault(node,0)){
    complete++;
}
}}
return complete; 
    }
}