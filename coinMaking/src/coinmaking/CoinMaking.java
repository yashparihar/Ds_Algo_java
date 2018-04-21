
//COIN MAKING DYANIC APPROACH.....................


package coinmaking;

import java.util.Scanner;


public class CoinMaking {

 
    
    public static class resultCoin{
        public static float totw;
        public static float benefit;
        public static int totc;
        
        int noofcoins;
        int val;
        
        resultCoin(int n,int v){
            noofcoins=n;
            val=v;
        }
        
        public static int getTotc(){
            return totc;
        }
    }
    

    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc=new Scanner(System.in);
                 System.out.println("sum=");
        int sum=sc.nextInt();
        
                 System.out.println("no of coins: ");
        int noofcoins = sc.nextInt();
        
        int coins[]=new int[noofcoins+1];
        int i=1;        
        
                 System.out.println("of:- ");
                 
        coins[0]=0;         
        while(i<=noofcoins){
            coins[i] = sc.nextInt();
            i++;
        }
        
        int dytab[][]=new int[noofcoins+1][sum+1];
        
        //FIILIN THE DYNAMIC TABLE.........
        getcoins(dytab,sum,noofcoins,coins);
                
      
        
        for(int x=0;x<=noofcoins;x++){
            for(int y=0;y<=sum;y++){
                System.out.print(" "+dytab[x][y]);
            }
            System.out.println();
        }
        
        
        resultCoin resCoin[]=new resultCoin[noofcoins];
        
        int totc = RetainCoins(resCoin , dytab ,coins , noofcoins , sum  );
        
        
           for(int x=0;x<totc ;x++){
              System.out.println("coin: "+resCoin[x].val+" totc:"+resCoin[x].noofcoins);
           }
        
        
    }

    private static int minimum(int i, int j) {
        if (i<=j || j==0) return i;
        else if (i==0 || i>j )
            return j;
        return 1;
    }

    private static void getcoins(int[][] dytab, int sum, int noofcoins, int[] coins) {
 
            for(int j=0;j<=sum;j++){
            dytab[0][j]=0;
        }
        for(int j=0;j<=noofcoins;j++){
            dytab[j][0]=0;
        }
        
        for(int x=1;x<=noofcoins;x++){
            for(int y=1;y<=sum;y++){
              
                if (coins[x] == y)
                    dytab[x][y]=1;
                
                else if (coins[x] > y )
                    dytab[x][y] = dytab[x-1][y];
                
                else{ //ie coins[x] < y...... 
                     if (x>1) 
                        dytab[x][y]=minimum( dytab[x-1][y] ,  (1 + dytab[x][y-coins[x]] )  );
                      else
                       dytab[x][y]=1+dytab[x][y-coins[x]] ;
                    
                   }
                    
            }   
        }
        
    
    }
    
    private static int RetainCoins(resultCoin[] resCoin, int[][] dytab, int[] coins, int noofcoins, int sum) {
       int x=noofcoins;
       int y= sum;
       
   //    resultCoin.totw=0;
       resultCoin.totc=0;
       
       int prev=0;
     
       while(dytab[x][y]!=0){
           while( dytab[x][y]>=dytab[x-1][y]  &&  dytab[x-1][y]!=0  ){
               x=x-1;
           }
           
          
           if (prev==x) 
                 resCoin[ resultCoin.totc - 1 ].noofcoins++;
           else {
               resCoin[ resultCoin.totc ]=new resultCoin( 1 , coins[x] );
               resultCoin.totc+=1;
               
               prev=x;
           }
           
           if (dytab[x][ y-coins[x] ]!=0)
               y-=coins[x];
           else         
               break;
           
       
       }
    
       return resultCoin.totc;
    }

      
}
