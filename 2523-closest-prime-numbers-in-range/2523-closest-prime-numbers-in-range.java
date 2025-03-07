class Solution {
    public int[] closestPrimes(int left, int right) {
    boolean[] prime=new boolean[right+1];
    Arrays.fill(prime,true) ; 
    prime[0]=false;
    prime[1]=false;
    //making the sive algorithm
    for(int p=2;p*p<=right;p++){
    if(prime[p]) {
    //making its multimule 0
    for(int i=p*p;i<=right;i+=p){
    prime[i]=false;
    }
    } 
    }
 int prev=-1;
 int diff=Integer.MAX_VALUE;
 int[] result=new int[]{-1,-1};
 for(int i=left;i<=right;i++){
if(prime[i]){
if(prev==-1){
prev=i;  
}
else {
if(i-prev<diff){
diff=i-prev;
result[0]=prev;
result[1]=i;
}
prev=i;
}}
 }   
return result;
    }
}