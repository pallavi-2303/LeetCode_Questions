class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
     int n1=nums1.length;
     int n2=nums2.length;
     int n=n1+n2;
    /* List<Integer> arr=new ArrayList<>();
     for(int num:nums1)  arr.add(num);
     for(int num:nums2)  arr.add(num);
     Collections.sort(arr);
     
     if(n%2==1) return arr.get(n/2);
     else return (arr.get(n/2)+arr.get(n/2-1))/2.0;*/
//we want n/2 and n/2-1 ellement index  so we can track it as both aeeat is soted we dont need extra space and extra complexity of sorting
int idx1=n/2-1;
int idx2=n/2;
int ele1=-1;
int ele2=-1;
int idx=0;
int i=0;
int j=0;
while(i<n1 && j<n2){
if(nums1[i]<=nums2[j]){
if(idx==idx1){
//we found the first element
ele1=nums1[i];
}
if(idx==idx2){
//we found the second element
ele2=nums1[i];
}
idx++;
i++;
}
else {
if(idx==idx1){
//we found the first element
ele1=nums2[j];
}
if(idx==idx2){
//we found the second element
ele2=nums2[j];
}
j++;
idx++;
}
}
while(i<n1){
if(ele1!=-1 && ele2!=-1) break;
if(idx==idx1){
//we found the first element
ele1=nums1[i];
}
if(idx==idx2){
//we found the second element
ele2=nums1[i];
}
i++;
idx++;
}
while(j<n2){
if(idx==idx1){
//we found the first element
ele1=nums2[j];
}
if(idx==idx2){
//we found the second element
ele2=nums2[j];
}
j++;
idx++;
}
return n%2==1 ? ele2 :(ele1+ele2)/2.0;

    }
}