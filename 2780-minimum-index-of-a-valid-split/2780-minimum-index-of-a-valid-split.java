class Solution {
    public int findMajority(List<Integer> nums){
    //we will find moorsvoting algorihtm to find majority Element
    int Majority=nums.get(0);
    int freq=1;
    for(int i=1;i<nums.size();i++){
    if(nums.get(i)==Majority) freq++;
    else freq--;
    //if the freq become 0 this element cant be majority till this index
    if(freq==0){
    Majority=nums.get(i);
    freq=1;
    }
    }
    return Majority;
    }
    public int minimumIndex(List<Integer> nums) {
     int n=nums.size();
     int majorityEle=findMajority(nums);
     //counting the frequency of majority Element to keep the track of majority 
    int freq=0;
    for(int num:nums){
    if(num==majorityEle) freq++;
    }
//counting the prefix count from left to keep track of freq as total freq=left+right
int prefixcount=0;
for(int i=0;i<n-1;i++){
if(nums.get(i)==majorityEle){
prefixcount++;
//right side count of majority element will be
freq--;
}
//checking the condition 
if(prefixcount>((i+1)/2) && freq>((n-1-i)/2)){
return i;
}
}
return -1;
    }
}