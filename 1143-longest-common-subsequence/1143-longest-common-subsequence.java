class Solution {
    public int lcs(int i,int j,String s1,String s2,int[][] dp){
    if(i==0 || j==0) return 0;
    if(dp[i][j]!=-1) return dp[i][j];
    //check if the character at both the indexes matches
    if(s1.charAt(i-1)==s2.charAt(j-1)){
    return dp[i][j]= 1+lcs(i-1,j-1,s1,s2,dp);
    }
    else {
    return dp[i][j]= Math.max(lcs(i-1,j,s1,s2,dp),lcs(i,j-1,s1,s2,dp));
    }
    }
    public int longestCommonSubsequence(String text1, String text2) {
     //since we have to find the longgest common subsequence in both the string we will keep one pointer and shrink the other and vice-versa
     int n1=text1.length();
     int n2=text2.length();
     int[][] dp=new int[n1+1][n2+1];
     for(int[] a:dp) Arrays.fill(a,-1);
     return lcs(n1,n2,text1,text2,dp) ;  
    }
}