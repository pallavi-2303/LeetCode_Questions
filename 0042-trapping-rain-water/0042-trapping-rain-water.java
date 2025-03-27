class Solution {
    public int trap(int[] arr) {
/*int n=height.length;
int[] nge=new int[n];
int[] pge=new int[n];
//pge
pge[0]=height[0];
  for(int i=1;i<n;i++) {
   pge[i]=Math.max(height[i],pge[i-1]);
 }
  nge[n-1]=height[n-1];
  for(int i=n-2;i>=0;i--) {
   nge[i]=Math.max(height[i],nge[i+1]);}
 
   
 //area
  int total=0;
 for(int i=0;i<n;i++) {
  total+=(Math.min(nge[i],pge[i])-height[i]);}
        return total;*/
int n=arr.length;
int l=0;
int r=n-1;
int leftmost=0;
int rightmost=0;
int total=0;
 while(l<=r) {
 if(arr[l]<=arr[r]) {
 if(arr[l]<leftmost) {
  total+=leftmost-arr[l];}
 else {
   leftmost=arr[l];}
    l++;}
  else {
 if(arr[r]<rightmost) {
  total+=rightmost-arr[r];}
   else {
   rightmost=arr[r];}
      r--;}
     }
        return total;



    

        
    }
}