class Solution {
    public int findLen(int idx1,int idx2,String s,String t,int[][] dp){
//base case
if(idx1==0){
//out of biubd case
return idx2;//we have to perform insert opeartion idx2 number of times 
}
if(idx2==0){
return idx1;//delete all the characters 
}
if(dp[idx1][idx2]!=-1){
return dp[idx1][idx2];
}
if(s.charAt(idx1-1)==t.charAt(idx2-1)){
return dp[idx1][idx2]=0+findLen(idx1-1,idx2-1,s,t,dp);
}
else {
//replace i-1 j-1 delete i-1 j insert i j-1 
return dp[idx1][idx2]=1+Math.min(findLen(idx1-1,idx2-1,s,t,dp),Math.min(findLen(idx1-1,idx2,s,t,dp),findLen(idx1,idx2-1,s,t,dp)));
}
}
    public int minDistance(String s, String t) {
        int n=s.length();
int m=t.length();
int[][] dp=new int[n+1][m+1];
for(int[] a:dp) 
Arrays.fill(a,-1);
return findLen(n,m,s,t,dp);
//Tabulation base case
// for(int i=0;i<=n;i++){
// dp[i][0]=i;//insert
// }
// for(int j=0;j<=m;j++){
// dp[0][j]=j;//delete 
// }
// for(int i=1;i<=n;i++){
// for(int j=1;j<=m;j++){
// if(s.charAt(i-1)==t.charAt(j-1)){
// dp[i][j]=1+dp[i-1][j-1];
// }
// else {
// dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
// }
// }
// }
// return dp[n][m];
    }
}