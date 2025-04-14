class Solution {
    public int LCS(int i,int j,String s1,String s2,int[][] dp){
    // if(i<0 || j<0) return 0;
     if(i==0 || j==0) return 0;
     if(dp[i][j]!=-1) return dp[i][j];
    //if  the string matches
    if(s1.charAt(i-1)==s2.charAt(j-1)){
    return dp[i][j]= 1+LCS(i-1,j-1,s1,s2,dp);
    }
    else return dp[i][j]=Math.max(LCS(i,j-1,s1,s2,dp),LCS(i-1,j,s1,s2,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
      int n1=text1.length();
      int n2=text2.length();
      int[][] dp=new int[n1+1][n2+1];
      for(int[] a:dp)  Arrays.fill(a,-1);
      return LCS(n1,n2,text1,text2,dp);
    }
}