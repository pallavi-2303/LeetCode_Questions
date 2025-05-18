class Solution {
    List<String> rowState=new ArrayList<>();
int mod=(int)1e9+7;
int[][] dp;
//TC->3*2^3-1
public void generateStates(String curr,char prev,int len){
if(len==3){
rowState.add(curr);
return;
}
for(char ch:new char[]{'R','Y','G'}){
if(prev==ch) continue;
generateStates(curr+ch,ch,len+1);
}
}
//(S*n*S*3)-> S-3*2^3-1 
//Sc-> O(S*n)+O(S*n)
public int solve(int remainingStates,int prevIdx,int m) {
if(remainingStates==0){
return 1;
}
if(dp[remainingStates][prevIdx]!=-1){
return dp[remainingStates][prevIdx];
}
int ways=0;
String prevState=rowState.get(prevIdx);
for(int i=0;i<rowState.size();i++){
 if(i==prevIdx) continue;
 String nextState=rowState.get(i);
 boolean valid=true;
 for(int c=0;c<m;c++){
if(prevState.charAt(c)==nextState.charAt(c)){
valid=false;
break;
}
 }
if(valid) {
ways=(ways+solve(remainingStates-1,i,m))%mod;
}
}
return dp[remainingStates][prevIdx]=ways;}

    public int numOfWays(int n) {
      //since there are only there colors we can generate states for all three colors in row and try to fill other rows with that
rowState.clear();
generateStates("",'$',0);
dp=new int[n][rowState.size()];
for(int[] a:dp)
Arrays.fill(a,-1);
int result=0;
for(int i=0;i<rowState.size();i++){
result=(result+solve(n-1,i,3))%mod;
}
return result;  
    }
}