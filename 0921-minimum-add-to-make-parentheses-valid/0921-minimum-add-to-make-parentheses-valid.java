class Solution {
    public int minAddToMakeValid(String s) {
      int minRequired=0;
      int openbracket=0;
      for(char ch:s.toCharArray()){
    if(ch=='('){
        openbracket++;
    }
    else {
    //if it si the closing parentheisis and for this closing parethesis we have a open bracket
    if(openbracket>0) {
    openbracket--;//means a valid mathc found
    }
    else {
    //if we dont have openbracket for this closing bracket
    minRequired++;
    }
    }
      }  
      return openbracket+minRequired;//if we dont encounter annyy closing for this opwning 
    }
}