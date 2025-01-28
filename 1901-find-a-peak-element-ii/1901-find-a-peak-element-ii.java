class Solution {
    public int[] findPeakGrid(int[][] mat) {
     //brute force checking out all the elements from all the direction and finding out the peak element
    int[] ans={-1};
    int maxi=-1;
     int n=mat.length;
     int m=mat[0].length;    
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
        if(mat[i][j]>maxi){
            maxi=mat[i][j];
            ans=new int[]{i,j};
        }
        }
    }
    return ans;
    }
}