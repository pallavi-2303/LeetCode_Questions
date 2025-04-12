class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
int m=t.length();
int stidx=-1;
/*Brute force-> Generating all the SubString and findinding minninum of all
//aproach-> Preinserting the characters of t if it is alrady present increasing the count if count become k and updating the minlen
int minlen=Integer.MAX_VALUE;
for(int i=0;i<n;i++){
HashMap<Character,Integer> mp=new HashMap<>();
//putting all the charcters of t in mp
for(int idx=0;idx<m;idx++){
char tch=t.charAt(idx);
mp.put(tch,mp.getOrDefault(tch,0)+1);
}
int count=0;
for(int j=i;j<n;j++){
char ch=s.charAt(j);
//if it is present in map and if it is preinserted 
if(mp.containsKey(ch)) {
 //if it is preinserted
if(mp.get(ch)>0) {
 count++;
 if(count==m) {
 if((j-i+1)<minlen) {
  minlen=j-i+1;
  stidx=i;}}
}}
mp.put(ch,mp.getOrDefault(ch,0)-1);
}
}*/
//better aproach of using a sliding window and two ponter and hashmap
HashMap<Character,Integer> mp=new HashMap<>();
//preinserting all the characters of t in map
for(int i=0;i<m;i++){
char ch=t.charAt(i);
mp.put(ch,mp.getOrDefault(ch,0)+1);
}
int l=0;
int r=0;
int count=0;
int minlen=Integer.MAX_VALUE;
while(r<n){
char ch=s.charAt(r);
//if this character is presnt in map and its value is greater means it is preinserted and we found the first character
if(mp.containsKey(ch)) {
 if(mp.get(ch)>0) {
  count++;
 }
}
//putting the value in map and try subtracting its count as we found first one
mp.put(ch,mp.getOrDefault(ch,0)-1);
//calculating sliding window 
while(count==m ) {
 //reducing the sliding window
 if((r-l+1)<minlen) {
  minlen=r-l+1;
  stidx=l;
 }
 //reducing the window
 char tch=s.charAt(l);
 mp.put(tch,mp.getOrDefault(tch,0)+1);
 if(mp.get(tch)>0){
  count--;}
 l++;
}
r++;}
return stidx==-1 ? "":s.substring(stidx,stidx+minlen);
    }
}