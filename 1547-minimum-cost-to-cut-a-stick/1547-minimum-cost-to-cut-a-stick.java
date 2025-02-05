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
        List<Integer> temp=new ArrayList<>();
int c=cuts.length;
temp.add(0);
for(int i=0;i<c;i++){
temp.add(cuts[i]);
}
temp.add(n);
Collections.sort(temp);
int[][] dp=new int[c+1][c+1];
for(int[] a:dp) Arrays.fill(a,-1);
return findCost(1,c,temp,dp);
    }
}