class Solution {
    public boolean lemonadeChange(int[] bills) {
     int n=bills.length;
     int five=0;
     int ten=0;
     int twenty=0;
     for(int i=0;i<n;i++)  {
    if(bills[i]==5){
five+=1;
    }
    else if(bills[i]==10){
//we customer give 10 rupees we have to give him change
ten+=1;//increase 10 ruppe count;
if(five>0){
  five-=1;  
}
else{
//five rupee is zero we dont have change
return false;
}
    }
    else {
    //customer give 20 rupees note
    twenty+=1;
    if(ten>0 && five>0){
        ten-=1;
        five-=1;
    }
    else if(five>=3){
    five-=3;
    }
    else {
        return false;//not possible
    }
    }
     } 
     return true;//we are able to give him corrcet change
    }
}