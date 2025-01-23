class MyQueue {
 Stack<Integer> st;
  Stack<Integer> helper;
    public MyQueue() {
      st=new Stack<>();
    helper=new Stack<>();
    }
    
    public void push(int x) {
    st.push(x);    
    }
    
    public int pop() {
if(st.isEmpty()) return -1;
     int size=st.size();
     for(int i=1;i<size;i++) {
    helper.push(st.pop());
     }  
int val=st.pop();
while(!helper.isEmpty()){
    st.push(helper.pop());
}
return val;
    }
    
    public int peek() {
        if(st.isEmpty()) return -1;
         int size=st.size();
     for(int i=1;i<size;i++) {
    helper.push(st.pop());
     }  
int val=st.peek();
while(!helper.isEmpty()){
    st.push(helper.pop());
} 
return val;
    }
    
    public boolean empty() {
      return  st.isEmpty(); 
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */