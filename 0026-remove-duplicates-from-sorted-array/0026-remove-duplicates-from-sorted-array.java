class Solution {
    public int removeDuplicates(int[] nums) {
       //brute force aproach but it gives number  in sorted order
      /* int n=nums.length;
       HashSet<Integer> st=new HashSet<>();
       //putting all elements in hashset as it stores only uniques ellement
       for(int num:nums){
        st.add(num);
       }
       int i=0;
       for(int it:st){
nums[i++]=it;
       }
       return st.size();*/
     /* int n=nums.length;
      HashMap<Integer,Integer> mp=new HashMap<>();
      for(int it:nums){
        mp.put(it,mp.getOrDefault(it,0)+1);
      }
      int idx=0;
      for(int it:mp.keySet()){
nums[idx++]=it;
      }
return mp.size();*/
//optimal aproach of using a two pointer
int i=0;
int n=nums.length;
for(int j=0;j<n;j++){
if(nums[i]!=nums[j]){
nums[++i]=nums[j];   
}
}
return i+1;//size of array
    }
}