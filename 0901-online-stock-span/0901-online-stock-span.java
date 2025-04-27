class StockSpanner {
class pair{
int ele;
int index;
pair(int ele,int index){
this.ele=ele;
this.index=index;
}
}
//we have to find out the prices that is less than or equalt  to current day
Stack<pair> st;
int idx;
    public StockSpanner() {
    st=new Stack<>();
idx=-1;
    }
    
    public int next(int price) {
        idx++;
    while(!st.isEmpty() && st.peek().ele<=price) {
    st.pop();
    } 
int pge=st.isEmpty() ? -1 :st.peek().index;
int count=idx-pge;
st.push(new pair(price,idx));
return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */