class Solution {
    public String minWindow(String s, String t) {
int n=s.length();
int m=t.length();

int stidx=-1;
//brute generating all subaaray and finding minimum of all length by preinserting the values of t
int minlen=Integer.MAX_VALUE;
/*for(int i=0;i<n;i++){
HashMap<Character,Integer> mp=new HashMap<>();
for(int idx=0;idx<m;idx++){
 mp.put(t.charAt(idx),mp.getOrDefault(t.charAt(idx),0)+1);}
int count=0;
for(int j=i;j<n;j++){
char ch=s.charAt(j);
if(mp.containsKey(ch)){
//if it is preinserted increase count we get 1 occurence of character
if(mp.get(ch)>0){
count+=1;}}
if(count==m){
if(j-i+1<minlen){
minlen=j-i+1;
 stidx=i;}}
 mp.put(ch,mp.getOrDefault(ch,0)-1);}}
  return stidx==-1 ? "":s.substring(stidx,stidx+minlen);*/
//optimal aproach of using sliding window
 int count=0;
int l=0;
int r=0;
HashMap<Character,Integer> mp=new HashMap<>();
 //preinsert the value of string t
for(int i=0;i<m;i++){
char tch=t.charAt(i);
mp.put(tch,mp.getOrDefault(tch,0)+1);}
while(r<n){
char ch=s.charAt(r);
if(mp.containsKey(ch)){
if(mp.get(ch)>0){
count+=1;}}
//inserting the new Character of string s 
mp.put(ch,mp.getOrDefault(ch,0)-1);
//calculating the minimum window
 while(count==m){
if(minlen>r-l+1){
minlen=r-l+1;
stidx=l;}
//reducing the window size from left and taking out the values 
char tch=s.charAt(l);
mp.put(tch,mp.getOrDefault(tch,0)+1);//we are taking out its value
if(mp.get(tch)>0){
//the value will be zero for character if it is not present in t
count-=1;}
 l++;}
  r++;}
   return stidx==-1 ? "":s.substring(stidx,stidx+minlen);
 



 
    }
}