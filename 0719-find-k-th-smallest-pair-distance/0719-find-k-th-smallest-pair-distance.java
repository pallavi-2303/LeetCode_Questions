class Solution {
public int find(int[] nums,int dis){
int n=nums.length;
int i=0;
int j=1;
//arr is sodted 1 1 3
int count=0;
while(j<n){
while(nums[j]-nums[i]>dis){
//shrink the window
i++;
}
//after this the distnace beyween i and j will be valid;
count=count+(j-i);
j++;
}
return count;
}
    public int smallestDistancePair(int[] nums, int k) {
    //since we have to dins the kth smallest distance pair from all the pairs we will simply find out the how many pairs have distance less than eual to particlular distance after finding the count we can calculate the distnace 
int n=nums.length;
int low=0;
Arrays.sort(nums);
int high=nums[n-1]-nums[0];
int res=0;
while(low<=high){
int midDis=low+(high-low)/2;
if(find(nums,midDis)<k){
low=midDis+1;
}
else {
res=midDis;
high=midDis-1;
}
}
return res;

    }
}