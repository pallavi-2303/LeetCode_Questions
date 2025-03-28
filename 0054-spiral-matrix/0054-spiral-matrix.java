class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
     int n=matrix.length;
int m=matrix[0].length;
int totalEle=0;
int toprow=0;
int bottomrow=n-1;
int leftcol=0;
int rightcol=m-1;
List<Integer> res=new ArrayList<>();
while(totalEle<n*m) {
//toprow->leftcol to rightcol
for(int j=leftcol;j<=rightcol && totalEle<n*m;j++){
res.add(matrix[toprow][j]);
totalEle++;
}
toprow++;
//rightcol->toprow to bottomrow
for(int i=toprow;i<=bottomrow && totalEle<n*m;i++){
res.add(matrix[i][rightcol]);
totalEle++;
}
rightcol--;
//bottomrow->rightcol to leftcol
for(int j=rightcol;j>=leftcol && totalEle<n*m;j--) {
res.add(matrix[bottomrow][j]);
totalEle++;
}
bottomrow--;
//leftcol->bottomrow->to toprow;
for(int i=bottomrow;i>=toprow && totalEle<n*m;i--){
res.add(matrix[i][leftcol]);
totalEle++;
}
leftcol++;
}
return res;   
    }
}