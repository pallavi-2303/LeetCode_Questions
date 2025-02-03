class Solution {

    public int findSubstring(int idx1,int idx2,String s1,String s2,int[][] dp) {
if(idx1==0 || idx2==0)
return 0;
if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
//if the character matches
if(s1.charAt(idx1-1)==s2.charAt(idx2-1))
return 1+findSubstring(idx1-1,idx2-1,s1,s2,dp);
else 
//if the chracters not matches shrink one and compare with the other one
return Math.max(findSubstring(idx1-1,idx2,s1,s2,dp),findSubstring(idx1,idx2-1,s1,s2,dp));
}
    public int longestCommonSubsequence(String s1, String s2) {
      int n1=s1.length();
int n2=s2.length();
int[][] dp=new int[n1+1][n2+1];
// for(int[] a:dp)
// Arrays.fill(a,-1);
// return findSubstring(n1,n2,s1,s2,dp); 
int[] prev=new int[n2+1];
int[] curr=new int[n2+1];
for(int i=0;i<=n1;i++){
dp[i][0]=0;
//prev[0]=0;
}
for(int j=0;j<=n2;j++){
dp[0][j]=0;
//prev[j]=0;
}
for(int i=1;i<=n1;i++){
//curr[0]=0;
 for(int j=1;j<=n2;j++){
 if(s1.charAt(i-1)==s2.charAt(j-1))
 dp[i][j]=1+dp[i-1][j-1];
 //curr[j]=1+prev[j-1];
 else // not match case
 dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
// curr[j]=Math.max(prev[j],curr[j-1]);
 }
// prev=curr;
}
//return prev[n2]; 
return dp[n1][n2];
    }
}