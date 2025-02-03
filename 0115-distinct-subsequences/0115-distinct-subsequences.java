class Solution {
public int findCount(int idx1,int idx2,String s1,String s2,int[][] dp) {
//base case
if(idx2==0) return 1;//one subsequnce if j exhaust
if(idx1==0) return 0;

if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
if(s1.charAt(idx1-1)==s2.charAt(idx2-1)){
//if the String matches we can match it with i or we cannot match it with this characters and give sum of both 
return findCount(idx1-1,idx2-1,s1,s2,dp) +findCount(idx1-1,idx2,s1,s2,dp);
}
else
return findCount(idx1-1,idx2,s1,s2,dp);
}
    public int numDistinct(String s1, String s2) {
        int n1=s1.length();
int n2=s2.length();
int[][] dp=new int[n1+1][n2+1];
// for(int[] a:dp)
// Arrays.fill(a,-1);
// return findCount(n1,n2,s1,s2,dp);
//base case for dp
int[] prev=new int[n2+1];
int[] curr=new int[n2+1];

for(int j=0;j<=n2;j++)
dp[0][j]=0;
//prev[0]=0;
for(int i=0;i<=n1;i++)
dp[i][0]=1;
//prev[j]=1;                                                                                   
for(int i=1;i<=n1;i++){
for(int j=1;j<=n2;j++){
if(s1.charAt(i-1)==s2.charAt(j-1)){
dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
curr[j]=prev[j-1]+prev[j];
}
else
dp[i][j]=dp[i-1][j];
//curr[j]=prev[j];
}
//prev=curr.clone();
}
return dp[n1][n2];
//return prev[n2];
    }
}