class Solution {
public void merge(int[] arr,int low,int mid,int high){
List<Integer> temp=new ArrayList<>();
int i=low;
int j=mid+1;
while(i<=mid && j<=high){
if(arr[i]<=arr[j]){
temp.add(arr[i++]);}
else {
temp.add(arr[j++]);}}
 while(i<=mid){
 temp.add(arr[i++]);}
while(j<=high){
temp.add(arr[j++]);}
for(int idx=low;idx<=high;idx++){
arr[idx]=temp.get(idx-low);}
        }
public int CountPairs(int[] nums,int low,int mid,int high){
int n=nums.length;
int count=0;
int right=mid+1;
for(int left=low;left<=mid;left++){
while(right<=high && (long)(nums[left])>2*(long)(nums[right])) {
 right++;}
count+=(right-(mid+1));}
return count;}



 
public int mergeSort(int[] arr,int low,int high){        
int count=0;
if(low>=high) return count;
int mid=low+(high-low)/2;
count+=mergeSort(arr,low,mid);
count+=mergeSort(arr,mid+1,high);
count+=CountPairs(arr,low,mid,high);
merge(arr,low,mid,high);
  return count;      }
    public int reversePairs(int[] nums) {
int n=nums.length;
/*int count=0;
//brute force generating all pairs
for(int i=0;i<n;i++){
for(int j=i+1;j<n;j++){
if((long)nums[i]>2*(long)nums[j]){
count++;}}}
 //return count;*/
 return mergeSort(nums,0,n-1);
    }
}