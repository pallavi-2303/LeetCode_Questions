class DisjointSet {
    List<Integer> size;
    List<Integer> rank;
    List<Integer> parent;

    DisjointSet(int n) {
        size=new ArrayList<>();
       rank=new ArrayList<>();
       parent=new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            size.add(1);
            rank.add(0);
        }
    }

    public int findulpar(int node) {
        if (parent.get(node) == node) {
            return node;
        }
        int ulp = findulpar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findulpar(u);
        int ulp_v = findulpar(v);
        if (ulp_u == ulp_v)
            return;
        if (size.get(ulp_u) >= size.get(ulp_v)) {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        } else {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        }
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findulpar(u);
        int ulp_v = findulpar(v);
        if (ulp_u == ulp_v)
            return;
        if (rank.get(ulp_u) > rank.get(ulp_v)) {
            parent.set(ulp_v, ulp_u);
        } else if (rank.get(ulp_v) > rank.get(ulp_u)) {
            parent.set(ulp_u, ulp_v);
        } else {
            parent.set(ulp_v, ulp_u);
            rank.set(ulp_u, rank.get(ulp_u) + 1);
        }
    }
}

class Solution {
public boolean isCommonFactor(int a,int b){
int factor=2;
while(factor<=a && factor<=b){
if(a%factor==0 && b%factor==0){
return true;
}
factor++;
}
return false;
}
public List<Integer> primeFactors(int num){
 List<Integer> prime=new ArrayList<>();
 int d=2;
 while(d*d<=num)  {
if(num%d==0){
//this is divisbile
prime.add(d);
while(num%d==0){
num/=d;
}
}
d++;
 } 
 if(num>1) prime.add(num);//valid for odd numbers which occurs in last
 return prime;
}
    public int largestComponentSize(int[] nums) {
//         //we have to find the size of compoents that are connected
//         //we can treat umbers to be be as node of the tree and find size of connected compents
// //we will tready each elemnt as node of graph
// int n=nums.length;
// DisjointSet ds=new DisjointSet(n);
// //storing ultimate parent in hash set to  find size of conncted compoent
// HashSet<Integer> st=new HashSet<>();
// for(int i=0;i<n;i++){
// for(int j=i+1;j<n;j++){
// if(isCommonFactor(nums[i],nums[j])){
// //means they can be connected in a gpraph 
// if(ds.findulpar(i)!=ds.findulpar(j)){
// //they can be connected
// ds.unionBySize(i,j);//an edge from i to j
// st.add(ds.findulpar(i));
// }
// }
// }
// }
// int maxi=0;
// for(int it:st){
// maxi=Math.max(maxi,ds.size.get(it));
// }
// return maxi;
//in this apraoch we are calculating the factors again and again we can find prime factors of all the all numbers and numbers that have same factor can be traedted as already connectoted
int n=nums.length;
HashMap<Integer,Integer> mp=new HashMap<>();
//to travese on factors and thrie numbers in wich the givrn factor come'
DisjointSet ds=new DisjointSet(n);
for(int i=0;i<n;i++){
List<Integer> factor=primeFactors(nums[i]);
//iterate over this factor
for(int fact:factor){
if(mp.containsKey(fact)){
//means their is a number which has same factor as this
ds.unionBySize(i,mp.get(fact));
}
else {
//factor not present
mp.put(fact,i);
}
}
}
int[] count=new int[n];
int maxi=0;
for(int i=0;i<n;i++){
count[ds.findulpar(i)]++;
maxi=Math.max(maxi,count[ds.findulpar(i)]);
}
return maxi;


    }
}