class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    int n=nums.length;
   /* HashSet<List<Integer>> st=new HashSet<>();
for(int i=0;i<n;i++){
for(int j=i+1;j<n;j++){
int sum=0;   
for(int k=j+1;k<n;k++){
if(nums[i]+nums[j]+nums[k]==0){
List<Integer> temp=Arrays.asList(nums[i],nums[j],nums[k]);
Collections.sort(temp);
st.add(temp);
}
}
}
}
List<List<Integer>> ans=new ArrayList<>(st);
return ans;*/
Arrays.sort(nums);
List<List<Integer>> res=new ArrayList<>();
for(int i=0;i<n;i++){
if(i>0 && nums[i]==nums[i-1]) continue;
int j=i+1;
int k=n-1;
int sum=0;
while(j<k){
sum=nums[i]+nums[j]+nums[k];
if(sum>0) k--;
else if(sum<0) j++;
else {
List<Integer> temp=Arrays.asList(nums[i],nums[j],nums[k]);
res.add(temp);
j++;
k--;
while(j<k && nums[j]==nums[j-1]) j++;
while(j<k && nums[k]==nums[k+1]) k--;
}
}
}
return res;
    }
}