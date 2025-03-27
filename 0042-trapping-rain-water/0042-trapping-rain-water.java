class Solution {
    public int trap(int[] arr) {
       int n=arr.length;
 /* int[] pge=new int[n];
  int[] nge=new int[n];
  pge[0]=arr[0];
  for(int i=1;i<n;i++){
   pge[i]=Math.max(pge[i-1],arr[i]);
  }
 nge[n-1]=arr[n-1];
 for(int i=n-2;i>=0;i--){
  nge[i]=Math.max(arr[i],nge[i+1]);
 }
 //Now calculating the amount to be stored
int sum=0;
 for(int i=0;i<n;i++){
  sum+=(Math.min(pge[i],nge[i])-arr[i]);   
 }
 return sum;*/
 //optimal aproach of using only indexe
 //in this we perform operation on smaller element first
 //in brute force since we are only taking the minimum of pregreater or nextgreater
 //so we will first traverse the smaller one
 int l=0;
 int r=n-1;
 int leftMax=0;
 int rightMax=0;
 int sum=0;
 while(l<r) {
 if(arr[l]<=arr[r]) {
 //we have someone bigger in right so it can store water
if(arr[l]<=leftMax) {
 sum+=(leftMax-arr[l] );
}
else {
 //he himself is greater in left so it will not contribute to water beacuse no one greart than this on left
 leftMax=arr[l];
}
l++;
 }
 else {
//right one is smaller
if(arr[r]<=rightMax){
 sum+=(rightMax-arr[r]);
}
else {
rightMax=arr[r];
}
r--;
 }
 }
 return sum; 
    }
}