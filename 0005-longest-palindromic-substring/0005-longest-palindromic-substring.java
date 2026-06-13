class Solution {
    public int solve(int i,int j,String s,int[][] dp){
    if(i>=j) return 1;
    if(dp[i][j]!=-1) return dp[i][j];
    if(s.charAt(i)==s.charAt(j)){
        return dp[i][j]=solve(i+1,j-1,s,dp);
    }
    else {
        return dp[i][j]=0;
    }
    }
    public String longestPalindrome(String s) {
     //brute force;
     int n=s.length();
     int max=0;
     int stIdx=-1;
     int[][] dp=new int[n][n];
     for(int[] a:dp) Arrays.fill(a,-1);
     for(int i=0;i<n;i++){
    for(int j=i;j<n;j++){
    if(solve(i,j,s,dp)==1){
    if(j-i+1>max){
    max=j-i+1;
    stIdx=i;
    }
    }
    }
     } 
     return s.substring(stIdx,stIdx+max);
    }
}