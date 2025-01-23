class Solution {
    public long subArrayRanges(int[] arr) {
       int n=arr.length;
//brute force generating all subrray and finding minimum and maximum of all and adding them up
long sum=0;
for(int i=0;i<n;i++){
 long mini=(long)arr[i];
 long maxi=(long)arr[i];
 for(int j=i;j<n;j++){
  mini=Math.min(mini,arr[j]);
  maxi=Math.max(maxi,arr[j]);
  sum+=(maxi-mini);
 }
}
return sum; 
    }
}