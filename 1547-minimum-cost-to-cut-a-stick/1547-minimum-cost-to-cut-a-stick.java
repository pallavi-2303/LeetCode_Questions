class Solution {
    public int findMinimum(int i,int j,List<Integer> cost,int[][] dp){
//if there is nothing to solve 
if(i>j) return 0;
if(dp[i][j]!=-1) {
return dp[i][j];
}
//we can cut at any index from i to j
int mini=(int)1e9;
for(int idx=i;idx<=j;idx++){
//we will remember where the last cut was made as this will give the length of stick
int cost2=cost.get(j+1)-cost.get(i-1)+findMinimum(i,idx-1,cost,dp)+findMinimum(idx+1,j,cost,dp);
mini=Math.min(cost2, mini);
}
return dp[i][j]=mini;
}
    public int minCost(int n, int[] cuts) {
      List<Integer> arr=new ArrayList<>();
arr.add(0);
int c=cuts.length;
for(int i=0;i<cuts.length;i++){
arr.add(cuts[i]);
}
arr.add(n);
Collections.sort(arr);
int[][] dp=new int[c+1][c+1];
for(int[] a:dp) {
Arrays.fill(a,-1);
}
return findMinimum(1,c,arr,dp);  
    }
}