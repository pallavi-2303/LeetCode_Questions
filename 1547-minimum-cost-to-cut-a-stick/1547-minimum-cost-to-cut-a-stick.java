class Solution {
    public int findCost(int i,int j,List<Integer> arr,int[][] dp) {
 //base case
 if(i>j) return 0;
 if(dp[i][j]!=-1) return dp[i][j];
 int mini=(int)(1e9);
 //try to cut at index starting from i to j
 for(int idx=i;idx<=j;idx++){
 int totalCost=arr.get(j+1)-arr.get(i-1)+findCost(i,idx-1,arr,dp)+findCost(idx+1,j,arr,dp);
 mini=Math.min(mini,totalCost);
 }
 return dp[i][j]=mini;
}
    public int minCost(int n, int[] cuts) {
        List<Integer> arr=new ArrayList<>();
int c=cuts.length;
arr.add(0);
for(int i=0;i<c;i++){
arr.add(cuts[i]);
}
arr.add(n);
Collections.sort(arr);
// int[][] dp=new int[c+1][c+1];
// for(int[] a:dp) Arrays.fill(a,-1);
// return findCost(1,c,temp,dp);
int[][] dp=new int[c+2][c+2];
for(int i=c;i>=1;i--){
for(int j=1;j<=c;j++){
    if(i>j) continue;
int mini=(int)(1e9);
for(int idx=i;idx<=j;idx++){
int cost=arr.get(j+1)-arr.get(i-1)+dp[i][idx-1]+dp[idx+1][j];
mini=Math.min(mini,cost);
}
dp[i][j]=mini;
}
}
return dp[1][c];
    }
}