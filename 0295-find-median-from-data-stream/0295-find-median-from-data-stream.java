class MedianFinder {
PriorityQueue<Integer> leftMaxHeap;
PriorityQueue<Integer> rightMinHeap;
    public MedianFinder() {
     leftMaxHeap=new PriorityQueue<>((x,y)->Integer.compare(y,x));
     rightMinHeap=new PriorityQueue<>((x,y)->Integer.compare(x,y)) ; 
    }
    
    public void addNum(int num) {
      //if it the first element
      if(leftMaxHeap.isEmpty())  {
    leftMaxHeap.offer(num);
    return;
      }
    if(num<leftMaxHeap.peek()){
        leftMaxHeap.offer(num);
    }
    else {
    rightMinHeap.offer(num);
    }
    BalancedHeap();
    }
    public void BalancedHeap(){
    if(rightMinHeap.size()>leftMaxHeap.size()){
    leftMaxHeap.offer(rightMinHeap.peek());
    rightMinHeap.poll();
    }
    else {
    if(rightMinHeap.size()<leftMaxHeap.size()-1){
      rightMinHeap.offer(leftMaxHeap.poll()) ; 
    }
    }
    }
    public double findMedian() {
     if(leftMaxHeap.size()>rightMinHeap.size()) {
    return (double)leftMaxHeap.peek();
     }  
     //ohertwise if the size is equal
     double ans=leftMaxHeap.peek()+rightMinHeap.peek();
     ans=ans/2.0;
     return ans;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */