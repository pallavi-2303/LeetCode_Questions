public class pair{
int first;
int second;
public pair(int first,int second){
this.first=first;
this.second=second;
}
}
class StockSpanner {
 
Stack<pair> st;
int idx;   
//List<Integer> ans;

    public StockSpanner() {
   // ans=new ArrayList<>(); 
    st=new Stack<pair>();
    idx=-1;
    }
    
    public int next(int price) {
    //  ans.add(price);
    //  int count=0;
    //  int size=ans.size();
    //  for(int i=size-1;i>=0;i--) {
    // if(ans.get(i)<=price)
    //  count++;
    //  else break;
    //  }
    //   return count;
    idx++;
    while(!st.isEmpty() && st.peek().first<=price){
    st.pop();
    }
  int pge=st.isEmpty() ? -1 : st.peek().second;
st.push(new pair(price,idx));
int count=(idx-pge);
return count;
    }
   
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */