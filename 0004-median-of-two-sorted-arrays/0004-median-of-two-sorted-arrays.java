class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
     int n1=nums1.length;
     int n2=nums2.length;
     List<Integer> arr=new ArrayList<>();
     for(int num:nums1)  arr.add(num);
     for(int num:nums2)  arr.add(num);
     Collections.sort(arr);
     int n=n1+n2;
     if(n%2==1) return arr.get(n/2);
     else return (arr.get(n/2)+arr.get(n/2-1))/2.0;

    }
}