class Solution {
 public int minOp(int i,int j,String s,String t,int[][] dp){
//base case
 if(j==0)//if(j<0) //min operation to convert s to t if j is exhausted then we delete all character of s
return i;//return i+1;
if(i==0)//if(i<0) //insert all t to s
return j; //return j+1;
if(dp[i][j]!=-1) return dp[i][j];
 //if character matches
if(s.charAt(i-1)==t.charAt(j-1))
 return dp[i][j]= 0+minOp(i-1,j-1,s,t,dp);
//if character not matches
 //perform operation and then move
 //insert i,j-1
 //replace i-1,j-1
//delete=i-1,j;
 else return dp[i][j]=1+Math.min(minOp(i-1,j-1,s,t,dp),Math.min(minOp(i,j-1,s,t,dp),minOp(i-1,j,s,t,dp)));}
    public int minDistance(String word1, String word2) {
 int n1=word1.length();
 int n2=word2.length();
int[][] dp=new int[n1+1][n2+1];
 /*for(int[] a:dp)
 Arrays.fill(a,-1);
 return minOp(n1,n2,word1,word2,dp);*/
 //Tabulation
//base case
int[] prev=new int[n2+1];
int[] curr=new int[n2+1];
 //if i==0;
 for(int j=0;j<=n2;j++) {
prev[j]=j; }// dp[0][j]=j;}//insert
   //j==0;
 //for(int i=0;i<=n1;i++){
//dp[i][0]=i;}//delete
 /*for(int i=0;i<=n1;i++)
   prev[0]=i;*/
for(int i=1;i<=n1;i++) {
 curr[0]=i;
for(int j=1;j<=n2;j++) {
 if(word1.charAt(i-1)==word2.charAt(j-1))
//dp[i][j]=0+dp[i-1][j-1];
 curr[j]=0+prev[j-1];
else
//dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));}}
 curr[j]=1+Math.min(prev[j-1],Math.min(prev[j],curr[j-1]));}
  prev=curr.clone();}
  //return dp[n1][n2];
   return prev[n2];      
        
    }
}