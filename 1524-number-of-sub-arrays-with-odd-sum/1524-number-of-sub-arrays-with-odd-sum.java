class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod=(int)1e9+7;
int result=0;
int even=1;
int odd=0;
int presum=0;
for(int num:arr) {
 presum+=num;
if(presum%2==0) {
result+=odd;
even++;
}
else {
result+=even;
odd++;
}
result=result%mod;}
return result;
    }
}