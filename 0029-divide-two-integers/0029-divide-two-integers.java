class Solution {
    public int divide(int dividend, int divisor) {
if(dividend==divisor) return 1;
    boolean sign=true;
if(dividend>=0 && divisor<0) 
    sign=false;
if(divisor>=0 && dividend<0)
    sign=false;
    long ans=0;
  //22/3-> 3*7->7=(2^2+2^1+2^0)
  //22-3*2^2=10
long n=Math.abs((long)(dividend));
long d=Math.abs((long)(divisor));
  while(n>=d) {
 int count=0;
//d<<count+1->d*2raise to power of count+1;
 while(n>=(d<<(count+1))) {
   count++;}
//1<<count->2 raise to power of count 
ans+=1<<count;
 n=n-(d<<count); }
 if(ans==(1<<31) && sign) {
   return Integer.MAX_VALUE;}
 if(ans==(1<<31) && !sign) {
   return Integer.MIN_VALUE;}
     
      return sign ? (int)(ans) : (int)(-1*ans);

 
        
    }
}