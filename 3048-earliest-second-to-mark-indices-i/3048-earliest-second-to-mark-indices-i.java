class Solution {
      int n,m;
    public boolean isValid(int[] nums,int[] changeIndices,int seconds){
    //let us keep track of last index of indices 
    int[] lastIndices=new int[n+1];//it will keep the last indiex of all indices of nums till seconds
Arrays.fill(lastIndices,-1);
    for(int i=0;i<=seconds;i++){
    int idx=changeIndices[i];
    lastIndices[idx]=i+1;//time is one based it keep track of ith index and its position in cnage index
    }
//we will keep track of postion and its index and process the element whose positon is smaller
for(int i=1;i<=n;i++){
if(lastIndices[i]==-1) return false;
}
TreeMap<Integer,Integer> mp=new TreeMap<>();
 for(int i=1;i<=n;i++)  {
int position=lastIndices[i];
mp.put(position,i);//position and index
 } 
int total=0;
for(Map.Entry<Integer,Integer> it:mp.entrySet()){
int position=it.getKey();
int index=it.getValue();
int req=nums[index-1]+1;
if(total+req>position) return false;
total+=req;
}
return true;
    }
  
    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
     n=nums.length;
     m=changeIndices.length;
    //let us try to find the time on basis of the last indices of occurence of iyj index in change indices
//it is possible that we can mark the indices less than 8  hours we check for every time;
for(int i=0;i<m;i++) {
if(isValid(nums,changeIndices,i)){
return i+1;//time is one based index
}
}
return -1;   
    }
}