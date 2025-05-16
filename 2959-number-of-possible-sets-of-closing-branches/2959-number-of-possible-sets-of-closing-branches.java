class Solution {
    public int numberOfSets(int n, int maxDistance, int[][] roads) {
       int ans=0;
//here we have to find the the subsets which are valid so total sunsets that can be formed is  2 ki power n and then we have to find the all tge distanve between all the nodes yo ensure no distance exceed the maximum value
//TC->O(2^n * n^3) sc-> n2
for(int set=0;set<(1<<n);set++){
//this is to find the subset in which we include nodes
//0 0 0 means no node chosen and 001 means 0th bit node chosen
int[][] grid=new int[n][n];
//to store matrix 
for(int[] a: grid) {
Arrays.fill(a,(int)1e9);
}
//traversing the node
for(int[] it:roads) {
int u=it[0];
int v=it[1];
int wt=it[2];
//finding the shorter distance check if it exist in set ot not
if(((set>>u)&1)==1 && ((set>>v)&1)==1){
grid[u][v]=Math.min(grid[u][v],wt);
grid[v][u]=Math.min(grid[v][u],wt);
}
}
//finding the sortest distance between to each node yo every other node 
for(int j=0;j<n;j++){
grid[j][j]=0;
}
for(int via=0;via<n;via++){
for(int i=0;i<n;i++){
for(int j=0;j<n;j++){
grid[i][j]=Math.min(grid[i][j],grid[i][via]+grid[via][j]);
}
}
}
boolean ok=true;
//check if the given subset is valid or not 
for(int i=0;i<n;i++){
for(int j=0;j<n;j++){
if(i==j) continue;
if(((set>>i)&1)==1 && ((set>>j)&1)==1) {
if(grid[i][j]>maxDistance) {
ok=false;
break;
}
}
}
}
ans+=ok ? 1 : 0;
}
return ans; 
    }
}