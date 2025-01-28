class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
     //brute force
    List<Integer> ans=new ArrayList<>();
    int n1=nums1.length;
    int n2=nums2.length;
    //putting in a single array and then finding the median 
    for(int i=0;i<n1;i++){
    ans.add(nums1[i]);
    }   
    for(int i=0;i<n2;i++){
    ans.add(nums2[i]);
    }  
int n=n1+n2;
Collections.sort(ans);
return n%2==0 ?(double)(ans.get(n/2)+ans.get(n/2-1))/(double)2 :(double) ans.get(n/2);
    }
}