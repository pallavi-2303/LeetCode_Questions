class ProductOfNumbers {
//Stack<Integer> st;
List<Integer> temp;
    public ProductOfNumbers() {
      temp=new ArrayList<>();
    }
    
    public void add(int num) {
       //st.push(num);
       temp.add(num);
    }
    
    public int getProduct(int k) {
//       if(st.size()<k)  return -1;
//       Stack<Integer> helper=new Stack<>();
//       int product=1;
//       while(!st.isEmpty() && k>0){
// int it=st.pop();
// product*=it;
// helper.push(it);
//     k--;
//       }
//       while(helper.size()>0){
//     st.push(helper.pop());
//       }
//       return product;
if(temp.size()==0) return -1;
int idx=temp.size()-1;
int product=1;
while(idx>=0 && k>0){
product*=temp.get(idx);
idx--;
k--;
}
return product;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */