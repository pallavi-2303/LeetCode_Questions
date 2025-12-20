class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int n1=nums1.length;
      int n2=nums2.length;
      //we will apply binary search on sorter array 
      //take 0 elelemnts from array 1 and n ellements from array 1 1 3 // 2
      if(n2<n1) return findMedianSortedArrays(nums2, nums1);
      int n=n1+n2;//elements in left 
      int required=(n+1)/2;
     int low=0;//take elements from array1 in left
     int high=n1;//take elements from array1 in left
     while(low<=high) {
    //elements from array 1
    int mid1=low+(high-low)/2;
    int mid2=required-mid1;//number of elelemnts from array2 ij left
    int l1=mid1-1>=0 ? nums1[mid1-1] :Integer.MIN_VALUE;
    int l2=mid2-1>=0 ? nums2[mid2-1] :Integer.MIN_VALUE;
    int r1=mid1<n1 ? nums1[mid1] :Integer.MAX_VALUE;
    int r2=mid2<n2? nums2[mid2] :Integer.MAX_VALUE;
    //l1 <=r1 and l2<=r2
    if(l1<=r2 && l2<=r1){
    //we found correct sorted half
    return n%2==1 ? (double)Math.max(l1,l2) : (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
    }
    else if(l1>r2){
    high=mid1-1;
    }
    else {
    low=mid1+1;
    }
     }
     return -1;
    }
}