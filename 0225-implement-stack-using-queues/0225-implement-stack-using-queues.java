class MyStack {
 Queue<Integer> q=new LinkedList<>();

    public MyStack() {
        
    }
    
    public void push(int x) {
      // q.add(x); 
     //pop and top efficient 
   if(q.size()==0) q.add(x);
   else {
  q.add(x);
  for(int i=1;i<=q.size()-1;i++){
   q.add(q.remove());}}
  
    
    }
    
    public int pop() {
   /*int n=q.size();
    if(n==0) return -1;
  for(int i=1;i<=n-1;i++) {
   q.add(q.remove());}
        return q.remove();*/
    return   q.remove();
    }
    
    public int top() {
  /*int n=q.size();
  if(n==0) return -1;
  for(int i=1;i<=n-1;i++) {
   q.add(q.remove());}
  int x=q.peek();
    q.add(q.remove());
      return x;*/
      return q.peek();
        
    }
    
    public boolean empty() {
   return q.size()==0 ? true : false;
        
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