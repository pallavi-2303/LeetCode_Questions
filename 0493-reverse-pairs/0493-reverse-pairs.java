class Solution {
    public void merge(int[] arr,int low,int mid,int high){
    List<Integer> temp=new ArrayList<>();
    int i=low;
    int j=mid+1;
    while(i<=mid && j<=high){
    if(arr[i]<=arr[j]) {
        temp.add(arr[i++]);
    }   
    else {
        temp.add(arr[j++]);
    }
    }
    while(i<=mid){
        temp.add(arr[i++]);
    }
    while(j<=high){
       temp.add(arr[j++]);  
    }
    //putting in array
    for(int idx=low;idx<=high;idx++){
        arr[idx]=temp.get(idx-low);
    }
    }
    public int reversePairs(int[] arr,int low,int mid,int high){
        int count=0;
for(int left=low;left<=mid;left++){
int right=mid+1;
while(right<=high && (long)arr[left]> (long)2*arr[right]){
right++;
}
count+=(right-(mid+1));
}
return count;
    }
   public int MergeSort(int[] arr,int low,int high){
int count=0;
if(low>=high) return count;
int mid=low+(high-low)/2;
count+=MergeSort(arr,low,mid);
count+=MergeSort(arr,mid+1,high);
//counting the pairs
count+=reversePairs(arr,low,mid,high);
merge(arr,low,mid,high);
return count;
   }
    public int reversePairs(int[] nums) {
      int n=nums.length;
//       int count=0;
//       for(int i=0;i<n;i++) {
//     for(int j=i+1;j<n;j++){
//     if((long)nums[i]>((long)2*nums[j])){
// count++;
//     }
//       } }
//       return count;
return MergeSort(nums,0,n-1);
    }
}