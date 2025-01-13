class Solution {
    public void reverse(int[] arr,int i,int j){
        while(i<j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        i++;
        j--;
        }
    }
    public void rotate(int[][] matrix) {
     int n=matrix.length;
     int m=matrix[0].length;
     //step->1 Taking transpose of each row
     for(int i=0;i<n;i++) {
    for(int j=i+1;j<n;j++){
    int temp=matrix[i][j];
    matrix[i][j]=matrix[j][i];
    matrix[j][i]=temp;
    }
     }  
     //step-> reverse each row
for(int i=0;i<n;i++){
    reverse(matrix[i],0,n-1);
}
    }
}