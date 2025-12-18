class Solution {
    public long findCount(int[] nums1,int[] nums2,long k,long product){
    int n1=nums1.length;
    int n2=nums2.length;
    //we have to find the count of elelemts that has product less than equal to give n product we will fix element of nums1 and check for nums2
long count=0;
for(int i=0;i<n1;i++){
//we are fixing nums1
if(nums1[i]>0){
long m=-1;//invalid index to left
int l=0;
int h=n2-1;
while(l<=h){
int mid=l+(h-l)/2;
long currProduct=(long)nums1[i]*nums2[mid];
if(currProduct<=product){
m=mid;
l=mid+1;
}
else {
h=mid-1;
}
}
count=count+(m+1);//m+1 possible products are available for given value of i and j
}
else {
long m=n2;//invalid index to right
int l=0;
int h=n2-1;
while(l<=h){
int mid=l+(h-l)/2;
long currProduct=(long)nums1[i]*nums2[mid];
if(currProduct<=product){
m=mid;
h=mid-1;//increase the product
}
else {
l=mid+1;
}
}
count=count+(n2-m);//this number of vald count
}
}
return count;
    }
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
    //since both arrays are sorted we can we can apply binary search on answer and choose a peoduct and find out how many elemnts give prdoduct less than equal to this product to keep track the kth smalllest product 
  long low=-(long)1e10 ;
  long high=(long) 1e10;
  long res=0;
  while(low<=high) {
long midProduct=low+(high-low)/2;
if(findCount(nums1,nums2,k,midProduct)<k){
low=midProduct+1;
}
else {
    res=midProduct;
    high=midProduct-1;
}
  }
  return res;  
    }
}