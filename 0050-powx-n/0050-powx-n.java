class Solution {
    public double myPow(double x, int n) {
     double ans=1;
long nn=n;
if(n<0) nn*=-1;
while(nn>0) {
if(nn%2==1) {
 ans*=x;
 nn-=1;
}
else {
 x*=x;
 nn=nn/2;
}
}
return n<0 ? 1/(double)ans : ans;   
    }
}