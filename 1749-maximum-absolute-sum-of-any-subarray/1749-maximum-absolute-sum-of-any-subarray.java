class Solution {
    public int maxAbsoluteSum(int[] arr) {
   int n=arr.length;
int maxsum=0;
int largestpos=0;
int largestneg=0;
int Maxi=Integer.MIN_VALUE;
int Mini=Integer.MAX_VALUE;
//so we will try to find maximum negative sum and maxinum positive sum and return maxi of all
// for(int i=0;i<n;i++){
// int sum=0;
// for(int j=i;j<n;j++){
// sum+=arr[j];
// maxi=Math.max(maxi,Math.abs(sum));
// }
// }
for(int i=0;i<n;i++){
largestpos+=arr[i];
Maxi=Math.max(Maxi,largestpos);
if(largestpos<0) {
  largestpos=0;
}
largestneg+=arr[i];
Mini=Math.min(Mini,largestneg);
if(largestneg>0) {
  largestneg=0;
}
maxsum=Math.max(maxsum,Math.max(largestpos,Math.abs(largestneg)));
}

return maxsum;

    }
}