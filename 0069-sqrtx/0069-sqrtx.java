class Solution {
    public int mySqrt(int x) {
     int ans=0;
     int st=1;
     int end=x;
     while(st<=end){
    int mid=st+(end-st)/2;
    long value=(long)mid*mid;
    if((long)x==value) return mid;
else if(value<(long)x){
ans=mid;
st=mid+1;
}
else end=mid-1;
     }  
     return ans;
    }
}