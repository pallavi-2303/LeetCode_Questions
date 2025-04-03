class MinStack {
/*public class pair{
    int first;
    long second;
    public pair(int first,long second){
    this.first=first;
    this.second=second;
    }
}*/
//Stack<pair> st;
long mini;
Stack<Long> st;
    public MinStack() {
   // st=new Stack<>(); 
st=new Stack<>();
mini=Long.MAX_VALUE;
    }
    
    public void push(int val) {
    if(st.isEmpty()){
    st.push((long)(val));
    mini=(long)val;
    }
    else if(val<(int)mini){
    //this is updated minimum as value of x is  smaller
    long newval=2*(long)val-mini;
st.push(newval);
mini=(long)val;
    }
    else {
    st.push((long)val);
    }
    }
    
//      if(st.isEmpty()){
//    st.push(new pair(val,(long)(val)));
//      }  
//      else {
//     st.push(new pair(val,Math.min((long)val,st.peek().second)));
//      } 
//     }
    
    public void pop() {
    if(st.isEmpty()) return;
    long val=st.pop();
   if(val<mini) {
mini=2*mini-val;
   }
    }
    
    public int top() {
   if(st.isEmpty()) return -1;      
long val=st.peek();
if(val<mini) return (int)mini;
else return (int)val;
    }
    
    public int getMin() {
      //  return (int)st.peek().second;
      return (int)(mini);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */