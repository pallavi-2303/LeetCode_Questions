class RecentCounter {
//we can keep track of the ranges and delete those whose time is greater than 3000
Queue<Integer> dq;

    public RecentCounter() {
        dq=new LinkedList<>();
    }
    
    public int ping(int t) {
      dq.add(t);
while(!dq.isEmpty() && t-dq.peek()>3000){
dq.poll();}
return dq.size();  
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */