class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    // int idx=0;//tc->n+nlogn sc->0(1)
    //  for(int i=m;i<m+n;i++)  {
    //     nums1[i]=nums2[idx++];
    //  } 
    //  Arrays.sort(nums1);
    //aproch 2// by using extra space
    List<Integer> temp=new ArrayList<>();
    int i=0;
    int j=0;
    while(i<m && j<n){
    if(nums1[i]<=nums2[j]){
        temp.add(nums1[i++]);
    }
    else {
    temp.add(nums2[j++]);
    }
    }
    while(i<m){
     temp.add(nums1[i++]);   
    }
while(j<n){
   temp.add(nums2[j++]);
}
int size=temp.size();
for(int idx=0;idx<size;idx++){
    nums1[idx]=temp.get(idx);
}
    }
}