class Solution {
    public double myPow(double x, int n) {
   double res=1;
   long nn=n;
   if(n<0) nn*=-1;
  while(nn>0) {
if((nn&1)==1){
//it is a odd power
res*=x;
nn-=1;
}
else {
x=x*x;
nn/=2;
}
  }
return  n<0 ? (double)1.0/res : res;

    }
}