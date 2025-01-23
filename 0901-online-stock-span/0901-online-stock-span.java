class Pair{
 int first;
 int second;
 public Pair(int first,int second) {
  this.first=first;
   this.second=second;}}
class StockSpanner {
  Stack<Pair> st=new Stack<>();
    int idx=-1;

    public StockSpanner() {
      idx=-1;
      st.clear();
    }
    
    public int next(int price) {
      idx++;
     int ans=0;
     while(!st.isEmpty() && st.peek().first<=price) {
      st.pop();}
   ans=idx-(st.isEmpty() ? -1 : st.peek().second);
     st.push(new Pair(price,idx));
        return ans;
         
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */