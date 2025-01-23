class Solution {
    public int[] asteroidCollision(int[] arr) {
    int n=arr.length;
    Stack<Integer> st=new Stack<>() ;
    for(int i=0;i<n;i++)  {
        if(arr[i]>0){
        st.push(arr[i]);
        }
        else {
    //it is a negative ellement
    while(!st.isEmpty() && st.peek()>0 && st.peek()<Math.abs(arr[i])){
    st.pop();
    }
    if(!st.isEmpty() && st.peek()>0 && st.peek()==Math.abs(arr[i])){
        st.pop();
    }
    //when to psuh the negative element
    else if(st.isEmpty() || st.peek()<0){
    st.push(arr[i]);
    }
        }
    }
    int m=st.size();
    int[] ans=new int[m];
    for(int i=m-1;i>=0;i--){
    ans[i]=st.pop();
    }
    return ans;
    }
}