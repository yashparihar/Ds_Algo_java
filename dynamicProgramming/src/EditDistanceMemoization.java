

import java.util.*;

public class EditDistanceMemoization {


    public static void main(String args[]){
        
        Scanner sc=new Scanner(System.in);
         int tc=sc.nextInt();
        
       for(int i=0;i<tc;i++){ 
        
        String str1 = sc.next();
        String str2 = sc.next();
        
        
        int distStore[][]=new int[str1.length()][str2.length()]; 
        int minEdit  = EditDist(distStore , str1 , str2 , str1.length()-1 , str2.length()-1) ;
        
        
        System.out.println(minEdit);
       }
    }
    
    public static int EditDist(int store[][] , String s1 , String s2 , int m, int n){
        
        
  //      System.out.println("m:"+m+" n="+n);
        if (m==-1) return n+1;
        if (n==-1) return m+1;
        
        if (store[m][n]!=0) return store[m][n];
                 
        if (s1.charAt(m)==s2.charAt(n)) 
            store[m][n]=EditDist(store , s1 , s2 , m-1 , n-1);
        else
             store[m][n] = 1 + min( EditDist(store , s1 , s2 , m , n-1) ,    //INSERTED
                                    EditDist(store , s1 , s2 , m-1 , n) ,    //REMOVED
                                    EditDist(store , s1 , s2 , m-1 , n-1) ); // REPLACED
        
        return  store[m][n];
        
                //store[m][n];        
                       
    }
    
    
    
    public static int min(int a , int b , int c){
        
        if (a<b && a<c) return a;
        else if (b<a && b<c) return b;
        else return c;
       
       
    }
    
}
