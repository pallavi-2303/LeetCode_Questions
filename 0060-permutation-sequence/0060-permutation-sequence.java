class Solution {
    public String getPermutation(int n, int k) {
       int fact=1;
List<Integer> numbers=new ArrayList<>();
//calculate the factorial till n-1 that would be number in each permutation starting with number
for(int i=1;i<n;i++){
 fact*=i;
 numbers.add(i);
}
numbers.add(n);
String ans="";
k=k-1;//as we are using 0 based indexing
while(true) {
ans=ans+numbers.get(k/fact);
numbers.remove(k/fact);
if(numbers.size()==0){
break;
}
//next value of k 
k=k%fact;
fact=fact/numbers.size();
}
return ans; 
    }
}