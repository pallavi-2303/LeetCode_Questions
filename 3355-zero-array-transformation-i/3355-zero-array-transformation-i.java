class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
     //since we can use difference array to transform in this we add a value at starting index and subtract at ending index it will give us no of operation to make it zero
int n=nums.length;
int[] diff=new int[n];
int m=queries.length;
for(int i=0;i<m;i++){
int start=queries[i][0];
int end=queries[i][1];
diff[start]+=1;
if(end+1<n) {
diff[end+1]-=1;
}
}
//caculating the cimulative sum
int[] res=new int[n];
int sum=0;
for(int i=0;i<n;i++){
sum+=diff[i];
res[i]=sum;//this will keep track the number of steps to make it 0
}
for(int i=0;i<n;i++){
if(nums[i]>res[i]){
//it can not transform to 0
return false;
}
}
return true;   
    }
}