class Solution {
   public class DisjointSet{
   List<Integer> parent=new ArrayList<>();
   List<Integer> size=new ArrayList<>();
   List<Integer> rank=new ArrayList<>();
   public DisjointSet(int n){
    for(int i=0;i<=n;i++){
      parent.add(i);
      size.add(1);
      rank.add(0);}}
  public int findulpar(int node){
   if(parent.get(node)==node)
   return node;
   int ulp=findulpar(parent.get(node));
   parent.set(node,ulp);
   return parent.get(node);
  }
  public void unionBySize(int u,int v){
  int ulp_u=findulpar(u) ;
  int ulp_v=findulpar(v);
  if(ulp_u==ulp_v) return;
  if(size.get(ulp_u)<size.get(ulp_v)){
   parent.set(ulp_u,ulp_v);
   size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
  }
  else {
  parent.set(ulp_v,ulp_u);
  size.set(ulp_u, size.get(ulp_u)+size.get(ulp_v));
  }
  }
  public void unionByRank(int u,int v){
  int ulp_u=findulpar(u);
  int ulp_v=findulpar(v);
  if(ulp_u==ulp_v) return;
  if(rank.get(ulp_u)<rank.get(ulp_v)){
   parent.set(ulp_u,ulp_v);
  }
  else if(rank.get(ulp_v)<rank.get(ulp_u)){
   parent.set(ulp_v,ulp_u);
  }
  else {
  parent.set(ulp_v,ulp_u);
  int ranku=rank.get(ulp_u);
  rank.set(ulp_u,ranku+1);
  }
  }
  }
    public int makeConnected(int n, int[][] edge) {
      //number of coonected components -1 will be number of edges
     //required to connect
    // as 1 2 3 4 nc=4 edge=3
    DisjointSet ds=new DisjointSet(n);
    //Connecting the components and fund bg extras edges
    int extEdge=0;
    for(int[] a:edge) {
    int u=a[0];
    int v=a[1];
    if(ds.findulpar(u)==ds.findulpar(v)){
    //they are already connected 
    extEdge++;
    }
    else {
     ds.unionBySize(u,v);
    }
    }
    int nc=0;
    for(int i=0;i<n;i++){
    if(i==ds.parent.get(i)) {
     nc++;//number of components 
    }
    }
    if(extEdge>=nc-1) return nc-1;
    return -1;
        
    }
}