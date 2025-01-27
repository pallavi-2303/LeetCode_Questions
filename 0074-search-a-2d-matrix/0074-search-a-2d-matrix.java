class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
int n=matrix.length;
int m=matrix[0].length;
//brute force search in entire matrix and tc->n2
 //since row and col are sorted so we can use this property
/*int i=0;
int j=m-1;
while(i<n && j>=0){
if(matrix[i][j]==target){
  return true;}
 else if(matrix[i][j]<target){
   i++;}
else {
  j--;}}
  return false;*/
   int low=0;
int high=n*m-1;
while(low<=high){
int mid=low+(high-low)/2;
int midEle=matrix[mid/m][mid%m];
if(midEle==target){
return true;}
else if(midEle<target){
low=mid+1;}
else {
high=mid-1;}}
return false;
        
    }
}