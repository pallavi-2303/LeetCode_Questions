class Solution {
  public void swap(int[] arr,int i,int j){
  int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;}
    public void moveZeroes(int[] nums) {
 int n=nums.length;
/*List<Integer> temp=new ArrayList<>();
for(int i=0;i<n;i++){
if(nums[i]!=0){
temp.add(nums[i]);}}
int idx=0;
for(int it:temp){
nums[idx++]=it;}
for(int i=idx;i<n;i++){
 nums[i]=0;}*/
//storing first zeroth element
int j=-1;
for(int i=0;i<n;i++){
if(nums[i]==0){
  j=i;
break;}}
 if(j==-1) return;//no zeroth ellement
for(int i=j+1;i<n;i++){
 if(nums[i]!=0){
   swap(nums,i,j);
     j++;}}
            





    }
}