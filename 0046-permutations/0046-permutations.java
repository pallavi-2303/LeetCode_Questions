class Solution {
  public void swap(int[] arr,int x,int y) {
 int temp=arr[x];
  arr[x]=arr[y];
   arr[y]=temp;}
 public void Generatepermutation(int[] arr,int idx,List<List<Integer>> ans) {
 //copy ds to ans
if(idx==arr.length) {
ArrayList<Integer> ds=new ArrayList<>();
 for(int i=0;i<arr.length;i++) {
  ds.add(arr[i]);}
  ans.add(new ArrayList<>(ds));
return;}
for(int i=idx;i<arr.length;i++){
 swap(arr,idx,i);
  Generatepermutation(arr,idx+1,ans);
  swap(arr,idx,i);}}
  
    
    public List<List<Integer>> permute(int[] nums) {
List<List<Integer>> ans=new ArrayList<>();
Generatepermutation(nums,0,ans);
        return ans;
        
    }
}