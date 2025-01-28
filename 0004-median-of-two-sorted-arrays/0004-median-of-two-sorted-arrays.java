class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
   
        //brute force of using extra space 
        /*List<Integer> temp=new ArrayList<>();
        int i=0;
        int j=0;
        int n=n1+n2;
        while(i<n1 && j<n2){
            if(nums1[i]<=nums2[j]){
                temp.add(nums1[i++]);
            }
            else {
                temp.add(nums2[j++]);
            }
        }
        while(i<n1){
            temp.add(nums1[i++]);
        }
        while(j<n2){
            temp.add(nums2[j++]);
        }
        return n%2==1 ?temp.get(n/2) :(double)((temp.get(n/2)+temp.get(n/2-1))/2.0);*/
        //better solution
       /* int idx1=n/2;
        int idx2=n/2-1;
        int ele1=-1;
        int ele2=-1;
        int count=0;
        int i=0;
        int j=0;
        while(i<n1 && j<n2){
        if(nums1[i]<=nums2[j]){
            if(count==idx1) ele1=nums1[i];
            if(count==idx2) ele2=nums1[i];
            i++;
            count++;
        }
            else{
                if(count==idx1) ele1=nums2[j];
                if(count==idx2) ele2=nums2[j];
                j++;
                count++;
            }
        }
        while(i<n1){
            if(count==idx1) ele1=nums1[i];
            if(count==idx2) ele2=nums1[i];
            i++;
            count++;
        }
        while(j<n2){
            if(count==idx1) ele1=nums2[j];
                if(count==idx2) ele2=nums2[j];
                j++;
                count++; 
        }
       return n%2==0 ?(double)(ele1+ele2)/2.0 :ele1; */
      //we will use binary search aproach as array is sorted
         int n1=nums1.length;
        int n2=nums2.length;
        if(n1>n2) return findMedianSortedArrays(nums2,nums1);
        int n=n1+n2;
         int left=(n+1)/2;//number of elements required in left part
        int low=0;
        int high=n1;
        while(low<=high){
        int mid1=low+(high-low)/2;//number of elements from aray 1 in left
        int mid2=left-mid1;//number of elements from array 2in left
        int l1=Integer.MIN_VALUE;
        int l2=Integer.MIN_VALUE;
        int r1=Integer.MAX_VALUE;
        int r2=Integer.MAX_VALUE;
        if(mid1-1>=0) l1=nums1[mid1-1];
        if(mid1<n1) r1=nums1[mid1];
        if(mid2-1>=0) l2=nums2[mid2-1];
        if(mid2<n2) r2=nums2[mid2];
        if(l1<=r2 && l2<=r1) {
        //correct left half
        if(n%2==1){
            return (double)Math.max(l1,l2);
        }
            else {
            return (double)((double)Math.max(l1,l2)+(double)Math.min(r1,r2))/2.0;
            }
        }
            else if(l1>r2){
                high=mid1-1;
            }
            else {
                low=mid1+1;
            }
        }
        return 0;//dummy
    }
}