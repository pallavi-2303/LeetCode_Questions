class Solution {
    public static class DisjointSet{
List<Integer> parent=new ArrayList<>();
List<Integer> size=new ArrayList<>();
List<Integer> rank=new ArrayList<>();
public DisjointSet(int n){
for(int i=0;i<=n;i++){
parent.add(i);
size.add(1);
rank.add(0);
}
}
public int findUlPar(int node){
if(node==parent.get(node))
return node;
int ulp=findUlPar(parent.get(node));
parent.set(node,ulp);
return parent.get(node);
}
public void unionByRank(int u,int v) {
int ulp_u=findUlPar(u);
int ulp_v=findUlPar(v);
if(ulp_u==ulp_v) return;
if(rank.get(ulp_u)<rank.get(ulp_v)){
 parent.set(ulp_u,ulp_v);
}
else if(rank.get(ulp_u)>rank.get(ulp_v)) {
  parent.set(ulp_v,ulp_u);
}
else {
parent.set(ulp_v,ulp_u);
rank.set(ulp_u,rank.get(ulp_u)+1);
}
}
public void unionBySize(int u,int v){
int ulp_u=findUlPar(u);
int ulp_v=findUlPar(v);
if(ulp_u==ulp_v) return;
if(size.get(ulp_u)<size.get(ulp_v)){
 parent.set(ulp_u,ulp_v);
 size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
}
else {
parent.set(ulp_v,ulp_u);
size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
}
}
}
    public int removeStones(int[][] stones) {
    int n=stones.length;
         int maxRow=0;
   int maxCol=0;
   for(int[] a:stones) {
   maxRow=Math.max(maxRow,a[0]);
   maxCol=Math.max(maxCol,a[1]);
   }
  DisjointSet ds=new DisjointSet(maxRow+maxCol+1);
 //Connecting nodes in disjointSet
HashMap<Integer,Integer> mp=new HashMap<>();
//To store nodes that has stones
 for(int[] a:stones) {
 int nodeRow=a[0];
 int nodeCol=a[1]+maxRow+1;
 if(ds.findUlPar(nodeRow)!=ds.findUlPar(nodeCol)){
  ds.unionBySize(nodeRow,nodeCol);
  mp.put(nodeRow,1);
  mp.put(nodeCol,1);
 }
 }
 int count=0;
 //Now counting the connected components 
for(int it:mp.keySet()) {
 if(ds.findUlPar(it)==it) {
  count++;
 }
}
  return n-count;
    }
}