class Solution {
    public int nthUglyNumber(int n) {
     //we can use dp to fill up nth ugly number
//And 3indexes that will point to three starting numbers
int[] dp=new int[n+1];
dp[1]=1;
int i2=1;
int i3=1;
int i5=1;
for(int num=2;num<=n;num++){
int i2ugly=dp[i2]*2;
int i3ugly=dp[i3]*3;
int i5ugly=dp[i5]*5;
int min=Math.min(i2ugly,Math.min(i3ugly,i5ugly));
if(min==i2ugly){
i2++;
}
if(min==i3ugly){
i3++;
}
if(min==i5ugly){
i5++;
}
dp[num]=min;
}
return dp[n];   
    }
}