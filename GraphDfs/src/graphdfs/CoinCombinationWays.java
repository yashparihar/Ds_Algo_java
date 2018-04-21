
package graphdfs;

import java.util.*;
import java.lang.*;
import java.math.BigInteger;

public class CoinCombinationWays {

    static class coinRec{
        int amount ; 
        int denom ;
        
        coinRec(int a , int d){
            amount = a;
            denom = d;
        }
    }
    
    public static void main(String args[]){
      
        Scanner sc=new Scanner(System.in);
        
        int amount = sc.nextInt();
        int m = sc.nextInt();
        //int DenomList[]=new int[m];
        ArrayList DenomList=new ArrayList();
        
        HashMap<coinRec , Long> coinMap = new HashMap();
        
        for(int i=0;i<m;i++){
            int d = sc.nextInt();
            
            if (d <= amount)
             DenomList.add( d );
        }
        Comparator c = Collections.reverseOrder();
        
        Collections.sort(DenomList , c);
        
        
        if (DenomList.isEmpty()) System.out.println("0");
        else {
       long ways = coinWays( coinMap , DenomList , 0 , amount);
     
        
        System.out.println(ways);
        }
    }
    
   
    public static long coinWays(HashMap<coinRec ,Long> coinMap , ArrayList dlist , int lno , int amt){
        long ways = 0;
        
        //long ways=0;
          if (lno >= ( dlist.size()-1) ) {
              
              if ( amt % (int)dlist.get(lno) !=0 )
                  return 0;
              else
                  return 1;
              
          }
        
     //   if ((int)dlist.get(lno) == 1) return 1;
        
      
        int denom = (int)dlist.get(lno);
        int i=0;
        
        while( (denom*i)<=amt){
       
             if ( coinMap.get(new coinRec(amt , denom )) != null){
                ways+=coinMap.get(new coinRec(amt , denom )  );
                i++;
                continue;
            }
            
            int inAmt = amt - (denom*i);
                 System.out.println( "inamt:"+amt+" denom:"+denom+" toamt:"+inAmt);
            
            ways+= coinWays( coinMap , dlist , lno+1 , inAmt) ;
            
            i++;
            
        }
        
        coinMap.put( new coinRec(amt , denom), ways);
        
        
        return ways;
        
    }
    
    
}