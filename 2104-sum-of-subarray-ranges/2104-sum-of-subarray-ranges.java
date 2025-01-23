class Solution {
public void NGE(int[] arr,int[] nge){
    int n=arr.length;
    Stack<Integer> st=new Stack<>();
    for(int i=n-1;i>=0;i--){
        while(!st.isEmpty() && arr[st.peek()]<arr[i]){
            st.pop();
        }
        nge[i]=st.isEmpty() ? n:st.peek();
        st.push(i);
    }
}
public void PGE(int[] arr,int[] pge){
    int n=arr.length;
    Stack<Integer> st=new Stack<>();
    for(int i=0;i<n;i++){
        while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
            st.pop();
        }
        pge[i]=st.isEmpty() ? -1:st.peek();
        st.push(i);
    }
}
public void NSE(int[] arr,int[] nse){
    int n=arr.length;
    Stack<Integer> st=new Stack<>();
    for(int i=n-1;i>=0;i--){
        while(!st.isEmpty() && arr[st.peek()]>arr[i]){
            st.pop();
        }
        nse[i]=st.isEmpty() ? n:st.peek();
        st.push(i);
    }
}
public void PSE(int[] arr,int[] pse){
    int n=arr.length;
    Stack<Integer> st=new Stack<>();
    for(int i=0;i<n;i++){
        while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
            st.pop();
        }
        pse[i]=st.isEmpty() ? -1:st.peek();
        st.push(i);
    }
}
public long findMinimum(int[] arr){
int n=arr.length;
int[] nse=new int[n];
int[] pse=new int[n];
NSE(arr,nse);
PSE(arr,pse);
long left=0;
long right=0;
long sum=0;
for(int i=0;i<n;i++){
left=i-pse[i];
right=nse[i]-i;
long total=left*right;//number of subbary in which thsi particular ellemet is smaller
sum=sum+(total*(long)arr[i]);
}
return sum;
}
public long findMaximum(int[] arr){
int n=arr.length;
int[] nge=new int[n];
int[] pge=new int[n];
NGE(arr,nge);
PGE(arr,pge);
long left=0;
long right=0;
long sum=0;
for(int i=0;i<n;i++){
left=i-pge[i];
right=nge[i]-i;
long total=left*right;//number of subbary in which thsi particular ellemet is smaller
sum=sum+(total*(long)arr[i]);
}
return sum;
}
    public long subArrayRanges(int[] arr) {
       int n=arr.length;
//brute force generating all subrray and finding minimum and maximum of all and adding them up
/*long sum=0;
for(int i=0;i<n;i++){
 long mini=(long)arr[i];
 long maxi=(long)arr[i];
 for(int j=i;j<n;j++){
  mini=Math.min(mini,arr[j]);
  maxi=Math.max(maxi,arr[j]);
  sum+=(maxi-mini);
 }
}
return sum; */
//finding out the minimum sum  of subarray and maximum of all subarray and subtracting theboth
return (findMaximum(arr)-findMinimum(arr));
    }
}