class Solution {
    public int[] nextGreaterElements(int[] arr) {
 int n=arr.length;
int[] nge=new int[n];
Arrays.fill(nge,-1);
for(int i=0;i<n;i++) {
for(int j=i+1;j<=n-1+i;j++) {
int idx=j%n;
if(arr[idx]>arr[i]) {
nge[i]=arr[idx];
break;}}}
return nge;
        
    }
}