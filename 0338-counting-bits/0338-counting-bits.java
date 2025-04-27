class Solution {
    public int count(int n){
    int c=0;
    while(n>0){
    c+=(n&1);//it gives the msb
    n>>=1;//right shift;
    }
    return c;
    }
    public int[] countBits(int n) {
    //brute force
    int[] ans=new int[n+1];
    for(int i=1;i<=n;i++) {
    ans[i]=count(i);
    } 
    return ans;  
    }
}