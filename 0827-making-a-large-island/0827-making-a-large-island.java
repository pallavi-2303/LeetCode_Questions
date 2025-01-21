class Solution {
    public static class DisjointSet{
 List<Integer> parent=new ArrayList<>();
 List<Integer> rank=new ArrayList<>();
 List<Integer> size=new ArrayList<>();
 public DisjointSet(int n){
 for(int i=0;i<=n;i++){
//initial Configuration
parent.add(i);
size.add(1);
rank.add(0);
 }
 }
 public int findUlPar(int node){
 if(node==parent.get(node)){
  return node;
 }
 int ulp=findUlPar(parent.get(node));
 parent.set(node,ulp);
 return parent.get(node);
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
 public void unionByRank(int u,int v){
 int ulp_u=findUlPar(u);
 int ulp_v=findUlPar(v);
 if(ulp_u==ulp_v) return;
 if(rank.get(ulp_u)<rank.get(ulp_v)){
  parent.set(ulp_u,ulp_v);
 }
 else if(rank.get(ulp_u)>rank.get(ulp_v)){
   parent.set(ulp_v,ulp_u);
 }
 else{
   // if rank of both are same
parent.set(ulp_v,ulp_u);
rank.set(ulp_u,rank.get(ulp_u)+1);
 }
 }
 }
 public boolean isValid(int row,int col,int n,int m){
 return row>=0 && col>=0 && row<n && col<m;
}
 
    public int largestIsland(int[][] grid) {
         int n=grid.length;
    int m=grid[0].length;
   DisjointSet ds=new DisjointSet(n*m);
   int[] delrow={-1,1,0,0};
   int[] delcol={0,0,-1,1};
   //Connecting all ones together if they share a cooomon boundary
  for(int row=0;row<n;row++) {
  for(int col=0;col<m;col++) {
   //given element is 0 there is no need to coonect it
  if(grid[row][col]==0) continue;
  //if it is one
 for(int i=0;i<4;i++) {
 int nrow=row+delrow[i];
 int ncol=col+delcol[i];
 //if it is valid and given neighbour is 1
 if(isValid(nrow,ncol,n,m) && grid[nrow][ncol]==1){
  int node=row*m+col;
  int adjNode=nrow*m+ncol;
  if(ds.findUlPar(node)!=ds.findUlPar(adjNode)){
  ds.unionBySize(node,adjNode);
  }
 }
 }
  }   
  }
 //All ones are connected Now converting 0 to one
 int maxCount=Integer.MIN_VALUE;
 for(int row=0;row<n;row++) {
  for(int col=0;col<m;col++) {
   HashSet<Integer> st=new HashSet<>();
  if(grid[row][col]==1) continue;
 //moving at adjacent side if it is 0
int sum=0;
 for(int i=0;i<4;i++) {
 int nrow=row+delrow[i];
 int ncol=col+delcol[i];
 if(isValid(nrow,ncol,n,m) && grid[nrow][ncol]==1){
 int adjNode=nrow*m+ncol;
 //adding its ultimate parent
 st.add(ds.findUlPar(adjNode));
 }
 }
  //Now calculation of count of ones
  for(int it:st) {
  sum+=ds.size.get(it);
  }
 maxCount=Math.max(maxCount,sum+1);//+1 for itself as 0 will be conbeted to 1
 
  }
//if there are all one
for(int col=0;col<n*n;col++){
 maxCount=Math.max(maxCount,ds.size.get(col));
}
 }
 return maxCount;
    }
}