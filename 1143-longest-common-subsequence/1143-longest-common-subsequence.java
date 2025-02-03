class Solution {
public int lcs(int idx1,int idx2,String s1,String s2,int[][] dp) {
 //base case
   if(idx1==0 || idx2==0)   
// if(idx1<0 || idx2<0) 
      return 0;
 if(dp[idx1][idx2]!=-1)
    return dp[idx1][idx2];
//if string match
 if(s1.charAt(idx1-1)==s2.charAt(idx2-1))
 return dp[idx1][idx2]= 1+lcs(idx1-1,idx2-1,s1,s2,dp);
//if string not match

else return dp[idx1][idx2]= 0+Math.max(lcs(idx1-1,idx2,s1,s2,dp),lcs(idx1,idx2-1,s1,s2,dp));}
    
    public int longestCommonSubsequence(String text1, String text2) {
int n1=text1.length();
int n2=text2.length();
//int[][] dp=new int[n1][n2];
int[][] dp=new int[n1+1][n2+1];
 //shifting the indexes to 1 place right
//for(int[] a: dp) {
 //  Arrays.fill(a,-1);}
 // return lcs(n1-1,n2-1,text1,text2,dp);
 // return lcs(n1,n2,text1,text2,dp);
//Tabulation
int[] prev=new int[n2+1];
int[] curr=new int[n2+1];
for(int i=0;i<=n1;i++) {
 //dp[i][0]=0;}
 prev[0]=0;}
for(int j=0;j<=n2;j++) {
// dp[0][j]=0;}
   prev[j]=0;}
for(int i=1;i<=n1;i++) {
for(int j=1;j<=n2;j++) {
//match condition 
if(text1.charAt(i-1)==text2.charAt(j-1))
//dp[i][j]=1+dp[i-1][j-1];
 curr[j]=1+prev[j-1];
//not match 
else 
//dp[i][j]=0+Math.max(dp[i-1][j],dp[i][j-1]);}}
 curr[j]=0+Math.max(prev[j],curr[j-1]);}
  prev=curr.clone();}
   // return dp[n1][n2];
       return prev[n2];
    }
}