class Solution {
    public boolean Compare(String s1,String s2){
    //string s1 is bigger than string s2 if both reaches end at same time they are lis
    if(s1.length()!=s2.length()+1) return false;
        int first=0;
        int second=0;
        while(first<s1.length()){
        if(second<s2.length() && s1.charAt(first)==s2.charAt(second)){
        first++;
            second++;
        }
            else //move only bigger string
                first++;
        }
        return first==s1.length() && second==s2.length();
    }
public Comparator <String> comp=(s1,s2)->s1.length()-s2.length();
    public int longestStrChain(String[] words) {
     int n=words.length;
    List<String> arr=new ArrayList<>();
        for(int i=0;i<n;i++){
        arr.add(words[i]);
        }
        //sort in asscending order of length of charaters
        arr.sort(comp);
        int[] dp=new int[n];
        int maxi=1;
        for(int i=0;i<n;i++){
          dp[i]=1;
            for(int prev=0;prev<i;prev++){
            if(Compare(arr.get(i),arr.get(prev)) && 1+dp[prev]>dp[i]){
        dp[i]=1+dp[prev];
            }
            }
            maxi=Math.max(maxi,dp[i]);
        }
        return maxi;
    }
}