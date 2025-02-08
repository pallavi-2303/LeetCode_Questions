class NumberContainers {
HashMap<Integer,TreeSet<Integer>> NumberToIdx;
HashMap<Integer,Integer> IdxToNumber;   
    public NumberContainers() {
     NumberToIdx=new HashMap<>();
     IdxToNumber=new HashMap<>();
    }
    
public void change(int index, int number) {
   //we can have a number at different index but at an index there would only be one number
 //delete if alrady present
 if(IdxToNumber.containsKey(index)){
  int prev=IdxToNumber.get(index);
  NumberToIdx.get(prev).remove(index);
  if(NumberToIdx.get(prev).size()==0)
  NumberToIdx.remove(prev);
 }
 IdxToNumber.put(index,number);
 if(!NumberToIdx.containsKey(number)){
 NumberToIdx.put(number,new TreeSet<>());  
 }
 NumberToIdx.get(number).add(index);

    }
    
    public int find(int number) {
   if(!NumberToIdx.containsKey(number)) return -1;
   return NumberToIdx.get(number).first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */