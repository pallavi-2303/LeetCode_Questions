class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> ans=new ArrayList<>() ;
    int n=matrix.length;
    int m= matrix[0].length;
    int totalEle=0;
    int leftcol=0;
    int toprow=0;
    int rightcol=m-1;
    int bottomrow=n-1;
    while(totalEle<m*n) {
    //for the top row-> leftcol to rightcol
for(int j=leftcol;j<=rightcol && totalEle<m*n;j++){
ans.add(matrix[toprow][j]);
totalEle++;
}
toprow++;
//rightcol-> toprow to bottomrow
for(int i=toprow;i<=bottomrow && totalEle<n*m;i++){
    ans.add(matrix[i][rightcol]);
    totalEle++;
}
rightcol--;
//bottom row->rightcol to leftcol
for(int j=rightcol;j>=leftcol && totalEle<m*n;j--){
    ans.add(matrix[bottomrow][j]);
    totalEle++;
}
bottomrow--;
//leftcol->bottomrow to toprow
for(int i=bottomrow;i>=toprow && totalEle<m*n;i--){
    ans.add(matrix[i][leftcol]);
    totalEle++;
}
leftcol++;
   }
   return ans;
    }
}