class Solution {
public int findMin(int idx1,int idx2,String s1,String s2,int[][] dp){
//base if any one the character exhaust
if(idx1==0) 
//we can insert all characters of j into i 
return idx2;
if(idx2==0) //delete operation
return idx1;
if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
//if string matches
if(s1.charAt(idx1-1)==s2.charAt(idx2-1)){
// no need to perform any operation just move to next string
return 0+findMin(idx1-1,idx2-1,s1,s2,dp);
}
//if not match we have to perform the 3 operations
//1 for the operation
//if insert is perform->i,j-1
//delete i-1,j
//replace i-1,j-1

return 1+Math.min(
findMin(idx1,idx2-1,s1,s2,dp),Math.min(findMin(idx1-1,idx2,s1,s2,dp),
findMin(idx1-1,idx2-1,s1,s2,dp)));
}
    public int minDistance(String s1, String s2) {
      int n1=s1.length();
int n2=s2.length();
int[][] dp=new int[n1+1][n2+1];
//for(int[] a:dp)
// Arrays.fill(a,-1);
// return findMin(n1,n2,s1,s2,dp); 
int[] prev=new int[n2+1];
int[] curr=new int[n2+1];

//base case
for(int j=0;j<=n2;j++){
//dp[0][j]=j;//deletion
prev[j]=j;
}
//for(int i=0;i<=n1;i++){
//dp[i][0]=i;//insertion
//prev[0]=i;
//}
for(int i=1;i<=n1;i++){
curr[0]=i;
 for(int j=1;j<=n2;j++){
 if(s1.charAt(i-1)==s2.charAt(j-1)){
 //dp[i][j]=0+dp[i-1][j-1];
 curr[j]=0+prev[j-1];
 }
 else {
 //dp[i][j]=1+Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
curr[j]=1+Math.min(curr[j-1],Math.min(prev[j],prev[j-1]));
 }
 }
 prev=curr.clone();
}
//return dp[n1][n2];
return prev[n2]; 
    }
}