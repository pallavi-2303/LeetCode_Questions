class Solution {
    public void reverse(int[] arr) {
int i=0;
int j=arr.length-1;
while(i<j) {
swap(arr,i,j);
i++;
j--;
}
}
public void swap(int[] arr,int i,int j) {
int temp=arr[i];
arr[i]=arr[j];
arr[j]=temp;
}
    public void rotate(int[][] matrix) {
      int n=matrix.length;
for(int i=0;i<n;i++){
for(int j=i+1;j<n;j++){
int temp=matrix[i][j];
matrix[i][j]=matrix[j][i];
matrix[j][i]=temp;
}
}
//reverse each row
for(int i=0;i<n;i++){
reverse(matrix[i]);
}  
    }
}