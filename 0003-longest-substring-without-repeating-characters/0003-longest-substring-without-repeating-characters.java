class Solution {
    public int lengthOfLongestSubstring(String s) {
       int n=s.length();
       //brute force generating all the subarray and fining max of all
    /*   int maxlen=0;//tc0(n2) scc->0(n)
       for(int i=0;i<n;i++){
    HashSet<Character> st=new HashSet<>();
    for(int j=i;j<n;j++){
     char ch=s.charAt(j);
     if(!st.contains(ch)){
        st.add(ch);
        maxlen=Math.max(maxlen,j-i+1);
     }
     else {
        break;
     }

    }
       }
       return maxlen;*/
       //optimal aproach of using a sliding window max
//        int maxlen=0;
//        HashMap<Character,Integer> mp=new HashMap<>();
//        int l=0;
//        int r=0;
//        while(r<n){
//     char ch=s.charAt(r);
//     while( l<r && mp.containsKey(ch)){
// char tch=s.charAt(l);
// mp.remove(tch);
// l++;
//     }
//     //the gven hracter will nnot present 
//     maxlen=Math.max(maxlen,r-l+1);
//     mp.put(ch,r);
//     r++;
//        }
//        return maxlen;
  int maxlen=0;
       HashMap<Character,Integer> mp=new HashMap<>();
       int l=0;
       int r=0;
       while(r<n){
    char ch=s.charAt(r);
   if(mp.containsKey(ch)){
    l=Math.max(l,mp.get(ch)+1);
    }
    //the gven hracter will nnot present 
    maxlen=Math.max(maxlen,r-l+1);
    mp.put(ch,r);
    r++;
       }
       return maxlen;
    }
}