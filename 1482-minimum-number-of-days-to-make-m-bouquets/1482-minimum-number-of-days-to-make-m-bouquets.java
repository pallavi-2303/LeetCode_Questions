class Solution {
        public boolean makeBouquet(int[] arr,int m,int k,int bloomDay) {
int n=arr.length;
int bouquet=0;
int flowers=0;
for(int i=0;i<n;i++) {
if(arr[i]<=bloomDay) {
//it is bloomed
flowers++;
}
else {
//if arr[i] > bloomDay
bouquet+=(flowers/k);
flowers=0;
}}
//at last if else statement is not executed 
bouquet+=(flowers/k);
return bouquet>=m;}
public int findMinimum(int[] arr){
int n=arr.length;
int mini=Integer.MAX_VALUE;
for(int i=0;i<n;i++){
 mini=Math.min(arr[i],mini);
}
return mini;
}
public int findMaximum(int[] arr) {
 int n=arr.length;
 int maxi=Integer.MIN_VALUE;
 for(int i=0;i<n;i++){
 maxi=Math.max(arr[i],maxi);
 }
 return maxi;
}
    public int minDays(int[] arr, int m, int k) {
//Mininum we have to wait for minnimum element to bloom because below that no flower would have blown and maximum we will have to wait for the maximum element of array as on that day all flowers would have blown 
//condition check if number of flowers given is less
int n=arr.length;
if(m*k>n) return -1;
int low=findMinimum(arr);
int high=findMaximum(arr);
/*brute force trying all values 
for(int i=low;i<=high;i++){
int NumberOfBouquet=makeBouquet(arr,k,i);
if(NumberOfBouquet==m){
return i;}}
return high;//maximum value;*/
//optimal binary Search
int ans=-1;
while(low<=high) {
int mid=low+(high-low)/2;
if(makeBouquet(arr,m,k,mid)) {
ans=mid;
high=mid-1;
}
else {
low=mid+1;
}
}
return ans;//ans;//both same
        
    }
}