class Solution {
    public int findMax(int[] arr) {
 int maxi=Integer.MIN_VALUE;
 for(int num:arr) {
 maxi=Math.max(maxi,num);
 }
 return maxi;
}
public boolean findHours(int[] arr,int k,int hours) {
int h=0;
int n=arr.length;
for(int i=0;i<n;i++) {
h+=Math.ceil((double)arr[i]/(double)k);
}
return h<=hours;
}
    public int minEatingSpeed(int[] nums, int hour) {
        //minimum koko can eat 1 banana and maximum he has to eat maximum pile contributing to 1 hour for each
int low=1;
int high=findMax(nums);
// for(int i=low;i<=high;i++){
// if(findHours(nums,i,hour)){
//  return i;
// }
// else {
// continue;
// }}
// return -1;//if not possible 
//binary Search 
int ans=-1;
while(low<=high){
 int mid=low+(high-low)/2;
 if(findHours(nums,mid,hour)) {
 ans=mid;
 high=mid-1;
 }
 else {
 low=mid+1;
 }
}
return ans;
    }
}