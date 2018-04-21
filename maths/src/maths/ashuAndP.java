
package maths;

import java.util.HashMap;
import java.util.Scanner;




public class ashuAndP {
    
    
    public static final int MAX = 1000000;
    
    
public static boolean isprime(int x){
        if (x<=1) return false;
        
        boolean flg=true;
        for(int i=2;i<=Math.sqrt(x); i++){
            if (x%i==0){
                flg=false; break;
            }
            
        }
        return flg;
    }    
    

public static int sieve(int n , int num , HashMap map){
    
    int tot=0;
    
    for(int m=1; m<=MAX/num  ; m++){
    
        
        int mul = num*m;
      //  System.out.println("multi = "+mul);
        if (!map.containsKey(mul) && (mul%n==0) ) {
            
        //    System.out.println("dont contains");
            tot++;
            map.put(mul, true);
        }
        
    }
    
    
    
    return tot;
}



public static void main(String args[]){
    
    Scanner sc=new Scanner(System.in);
    int t = sc.nextInt();
    
   
    for(int i=0;i<t;i++){
        int n =sc.nextInt();
        
        int allTot = 0;
        
        
       // if (n>2) allTot = MAX/2;
        
        HashMap map = new HashMap();
        

        for(int p=3;p<n;p++){
       
            if (isprime(p)){
            //    System.out.println("seiving of prime "+p);
                
                allTot+=sieve(n , p , map) ;
            }
                
        }
        
        int ans = MAX/n - allTot;

        System.out.println(ans);
    }
    
    
    
    
}



    
    
}
