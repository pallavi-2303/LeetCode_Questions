class Solution {
    public int findPaths(int i,int j,int[][] dp){
    if(i<0 || j<0) return 0;
    if(i==0 && j==0) return 1;
    if(dp[i][j]!=-1) return dp[i][j];
    int up=findPaths(i-1,j,dp);
    int left=findPaths(i,j-1,dp);
    return dp[i][j]=up+left;
    }
    public int uniquePaths(int m, int n) {
     //let us take the path from m and n
     int[][] dp=new int[m][n];
    //  for(int[] a:dp) Arrays.fill(a,-1);
    //  return findPaths(m-1,n-1,dp);
    dp[0][0]=1;
    for(int i=0;i<m;i++){
    for(int j=0;j<n;j++){
    if(i==0 && j==0){
    dp[i][j]=1;
    }
    else {
    int up=0;
    if(i-1>=0) up=dp[i-1][j];
    int left=0;
    if(j-1>=0) left=dp[i][j-1];
    dp[i][j]=up+left;
    }
    }
    }
    return dp[m-1][n-1];
    }
}