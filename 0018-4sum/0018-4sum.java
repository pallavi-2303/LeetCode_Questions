class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
      //since we have to find unique pairs in brute force we will use a hashset to store umber
       int n=nums.length;
       List<List<Integer>> ans=new ArrayList<>();
//       HashSet<List<Integer>> st=new HashSet<>();
//       for(int i=0;i<n;i++) {
//         for(int j=i+1;j<n;j++){
//         for(int k=j+1;k<n;k++){
//     for(int l=k+1;l<n;l++){
//     long sum=nums[i];
//     sum+=nums[j];
//     sum+=nums[k];
//     sum+=nums[l];
//     if((int)sum==target){
//     List<Integer> temp=Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
//     temp.sort(null);//sorting to avoid duplicacy
//     st.add(temp);
//     }
//     }
//         }
//         }
//       }
//       List<List<Integer>> result=new ArrayList<>(st);
//       return result;
//optimal aproch of uusing two pointer
Arrays.sort(nums);
for(int i=0;i<n;i++){
if(i!=0 && nums[i]==nums[i-1]) continue;
for(int j=i+1;j<n;j++){
 if(j>i+1 && nums[j]==nums[j-1])  continue;
 int k=j+1;
 int l=n-1;
 while(k<l) {
long sum=nums[i];
sum+=nums[j];
sum+=nums[k];
sum+=nums[l];
if(sum<target) k++;
else if(sum>target) l--;
else {
//sum==target
List<Integer> temp=Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
ans.add(temp);
k++;
l--;
while(k<l && nums[k]==nums[k-1]){
k++;
}
while(k<l && nums[l]==nums[l+1]){
    l--;
}
}
 }
}
}
return ans;



     } }