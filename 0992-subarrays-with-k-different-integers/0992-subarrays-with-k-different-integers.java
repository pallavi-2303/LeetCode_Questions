class Solution {
    public int numberOfSubarray(int[] nums,int k){
        if(k<0) return 0;
        int l=0;
        int r=0;
        int n=nums.length;
        int count=0;
        HashMap<Integer,Integer> mp=new HashMap<>();
        while(r<n){
        mp.put(nums[r],mp.getOrDefault(nums[r],0)+1);
        while(mp.size()>k){
            mp.put(nums[l],mp.get(nums[l])-1);
            if(mp.get(nums[l])==0){
                mp.remove(nums[l]);
            }
            l++;
        }
        count+=(r-l+1);
        r++;
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
    int n=nums.length;
    int count=0;
    /*brute force generating all the subarray
    for(int i=0;i<n;i++) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int j=i;j<n;j++){
mp.put(nums[j],mp.getOrDefault(nums[j],0)+1);
if(mp.size()==k) count+=1;
else if(mp.size()>k) break;
        }
    }   
    return count;*/
    //optimal aproch of using sliding window maximum
//subarray with integer<=k -integer<=k-1
return numberOfSubarray(nums,k)-numberOfSubarray(nums,k-1);
    }
}