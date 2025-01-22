class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    int n1=nums1.length;
    int n2=nums2.length; 
    //first we will find next greater element of nums2
    int[] nge=new int[n2];
    Stack<Integer> st=new Stack<>();
    for(int i=n2-1;i>=0;i--){
        while(!st.isEmpty() && st.peek()<=nums2[i]){
            st.pop();
        }
        if(st.isEmpty()) nge[i]=-1;
        else {
        nge[i]=st.peek();}
        st.push(nums2[i]);
    }
    HashMap<Integer,Integer> mp=new HashMap<>();
    for(int i=0;i<n2;i++){
    mp.put(nums2[i],nge[i]);
    }
    int[] ans=new int[n1];
    //putting all next greater of nums1 
    for(int i=0;i<n1;i++){
ans[i]=mp.get(nums1[i]);
    }
    return ans;
    }
}