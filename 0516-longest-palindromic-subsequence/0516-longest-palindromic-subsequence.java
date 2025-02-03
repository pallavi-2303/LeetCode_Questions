class Solution {
    public int findLCS(int idx1,int idx2,String s,String t,int[][] dp){
    //base case out of bound case
    if(idx1==0 || idx2==0) return  0;
    if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
    //we the chracter mathces
    if(s.charAt(idx1-1)==t.charAt(idx2-1))
    return 1+findLCS(idx1-1,idx2-1,s,t,dp);
    //not matchh case
    else return Math.max(findLCS(idx1-1,idx2,s,t,dp),findLCS(idx1,idx2-1,s,t,dp));
    }
    public int longestPalindromeSubseq(String s) {
      //since we have to find longest pallaindromic subesequence we need to reverse the string the string and then we can find pallindrome;
String t=new StringBuilder(s).reverse().toString();


int n=s.length();
int[][] dp=new int[n+1][n+1];
for(int[] a:dp) Arrays.fill(a,-1);
return findLCS(n,n,s,t,dp);
    }
}