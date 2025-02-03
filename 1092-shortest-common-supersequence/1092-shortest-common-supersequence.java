class Solution {
public void findDp(String s1,String s2,int[][] dp) {
 int n1=s1.length();
 int n2=s2.length();
 for(int i=0;i<=n1;i++)
 dp[i][0]=0;
 for(int j=0;j<=n2;j++)
 dp[0][j]=0;
 for(int i=1;i<=n1;i++){
 for(int j=1;j<=n2;j++){
if(s1.charAt(i-1)==s2.charAt(j-1)){
dp[i][j]=1+dp[i-1][j-1];
}
else {
dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
}
 }
 }
}
    public String shortestCommonSupersequence(String s1, String s2) {
      //in shortest common supersubsequence we take the common guys only once
int n1=s1.length();
int n2=s2.length();
int[][] dp=new int[n1+1][n2+1];
findDp(s1,s2,dp);
String ans="";
//Making the answer
int i=n1;
int j=n2;
while(i>0 && j>0) {
if(s1.charAt(i-1)==s2.charAt(j-1)){
//if the character matches we take only once
ans+=s1.charAt(i-1);
i--;
j--;
}
else if(dp[i-1][j]>dp[i][j-1]) {
 //we will move backward so we take this character to answer 
 ans+=s1.charAt(i-1);
 i--;
}
else {
 ans+=s2.charAt(j-1);
 j--;
}
}
while(i>0){
 ans+=s1.charAt(i-1);
 i--;
}
while(j>0){
    ans+=s2.charAt(j-1);
    j--;
}
String str=new StringBuilder(ans).reverse().toString();
return str;  
    }
}