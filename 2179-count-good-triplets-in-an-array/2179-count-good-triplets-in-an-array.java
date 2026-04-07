class Solution {
    public void updateQuery(int i,int l,int r,int updateIdx,long[] segment){
    if(l==r){
    segment[i]=1;
    return;
    }
int mid=l+(r-l)/2;
if(updateIdx<=mid){
updateQuery(2*i+1,l,mid,updateIdx,segment);
}
else {
updateQuery(2*i+2,mid+1,r,updateIdx,segment);
}
segment[i]=segment[2*i+1]+segment[2*i+2];
    }
public long findQuery(int st,int end,int i,int l,int r,long[] segment){
if(r<st || l>end || l>r){
return 0;
}
if(l>=st && r<=end){
return segment[i];
}
int mid=l+(r-l)/2;
return findQuery(st,end,2*i+1,l,mid,segment)+findQuery(st,end,2*i+2,mid+1,r,segment);

}
    public long goodTriplets(int[] nums1, int[] nums2) {
    int n=nums1.length;
     HashMap<Integer,Integer> mp=new HashMap<>();
    for(int i=0;i<n;i++){
    mp.put(nums2[i],i);
    } 
long[] segment=new long[4*n];
updateQuery(0,0,n-1,mp.get(nums1[0]),segment);
long total=0;
for(int i=1;i<n;i++){
int idx=mp.get(nums1[i]);
long leftCommon=findQuery(0,idx,0,0,n-1,segment);
long leftUnCommon=i-leftCommon;
long rightTotal=(n-1-idx);
long rightCommon=rightTotal-leftUnCommon;
total=total+(leftCommon*rightCommon);
updateQuery(0,0,n-1,mp.get(nums1[i]),segment);

}
return total;
    }
}