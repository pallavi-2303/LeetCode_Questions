class SmallestInfiniteSet {
//since we have to track the smallest elelemnt we can use PriorityQueue and no two same element added in we need set
PriorityQueue<Integer> pq;
HashSet<Integer> st;
int current;
    public SmallestInfiniteSet() {
       pq=new PriorityQueue<>((a,b)->Integer.compare(a,b)); 
       st=new HashSet<>();
       current=1;
    }
    
    public int popSmallest() {
      //if priotiryty Queue is not empty 
      int result;
      if(!pq.isEmpty()){
    result=pq.poll();
    st.remove(result);
      } 
      else  {
    result=current;
    current++;
      }
      return result; 
    }
    
    public void addBack(int num) {
     if(num>=current || st.contains(num)) return;
     //if it is smaller elelelemnt
     pq.add(num);
     st.add(num);  
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */