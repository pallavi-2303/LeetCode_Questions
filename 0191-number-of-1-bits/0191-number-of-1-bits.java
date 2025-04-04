class Solution {
    public int hammingWeight(int n) {
    int count=0;
    while(n>0) {
  //  if(n%2==1) count++;
  count+=(n&1);
  //  n/=2;
  n=(n>>1);
    }  
    return count; 
    }
}