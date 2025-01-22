class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
 int n=nums1.length;
 int m=nums2.length;
 HashMap<Integer,Integer> mp=new HashMap<>();
Stack<Integer> st=new Stack<>();
mp.put(nums2[m-1],-1);
st.push(nums2[m-1]);
 for(int i=m-2;i>=0;i--) {
  while(st.size()>0 && st.peek()<=nums2[i]) {
   st.pop();}
 if(st.size()==0) mp.put(nums2[i],-1);
else {
mp.put(nums2[i],st.peek());}
  st.push(nums2[i]);}
  int[] ans=new int[n];
  for(int i=0;i<n;i++) {
    ans[i]=mp.get(nums1[i]);}
        return ans;
        
    }
}