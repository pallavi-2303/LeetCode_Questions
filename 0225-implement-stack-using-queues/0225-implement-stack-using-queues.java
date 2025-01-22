class MyStack {
Queue<Integer> q=new LinkedList<>();
    public MyStack() {
        
    }
    
    public void push(int x) {
      //push efficient function
      q.add(x) ;
    }
    
    public int pop() {
     if(q.size()==0)   return -1;
     int size=q.size();
     for(int i=1;i<size;i++){
q.add(q.remove());
     }
return q.poll();
    }
    
    public int top() {
 if(q.size()==0) return -1;
 int size=q.size();
 for(int i=1;i<size;i++){
    q.add(q.remove());
 }
int x=q.peek();
q.add(q.remove());
return x;   
    }
    
    public boolean empty() {
       return q.isEmpty(); 
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */