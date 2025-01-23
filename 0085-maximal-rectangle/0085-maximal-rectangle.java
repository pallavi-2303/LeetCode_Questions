class Solution {
      public void NSE(int[] arr,int[] nse){
    Stack<Integer> st=new Stack<>() ;
    int n=arr.length;
    for(int i=n-1;i>=0;i--) {
    while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
        st.pop();
    }
    nse[i]=st.isEmpty() ? n:st.peek();
    st.push(i);
    }  
    }
      public void PSE(int[] arr,int[] pse){
    Stack<Integer> st=new Stack<>() ;
    int n=arr.length;
    for(int i=0;i<n;i++) {
    while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
        st.pop();
    }
    pse[i]=st.isEmpty() ? -1:st.peek();
    st.push(i);
    }  
    }
    public int largestRectangle(int[] heights){
      int n=heights.length;
       int[] nse=new int[n];
       int[] pse=new int[n];
        NSE(heights,nse);
        PSE(heights,pse);
     int maxArea=0;
     //calculating  area of ech rectange
     for(int i=0;i<n;i++) {
    int area=heights[i]*(nse[i]-pse[i]-1);
    maxArea=Math.max(area,maxArea);
     }
     return maxArea;  
    }
    public int maximalRectangle(char[][] matrix) {
     int n=matrix.length;
     int m=matrix[0].length;
     int maxi=0;
     int[] heights=new int[m];
     for(int i=0;i<n;i++) {
    for(int j=0;j<m;j++){
    if(matrix[i][j]=='1'){
    heights[j]+=1;
    }
    else {
    heights[j]=0;
    }
    }
    maxi=Math.max(maxi,largestRectangle(heights));
     }
     return maxi;
    }
}