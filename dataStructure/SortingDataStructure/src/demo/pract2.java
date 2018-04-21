/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.util.*;

/**
 *
 * @author Yash
 */
public class pract2 {
    
    
    public static void main(String args[]){
        
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
       int K =sc.nextInt();
           int tot=0;
       ArrayList list = new ArrayList();
    //   int lis[]=new int[1000];
       for(int i=0;i<N;i++){
           int e =sc.nextInt();
           list.add(e);
         /*if (!list.contains(e))
             list.add(e);
         
         if (list.contains(e-K))
             tot++;
          if (list.contains(e+K))
             tot++;    
       
         */
       }
       
      Collections.sort(list);
      
      int i=0;
      int j=1;
      
      while(j<N){
          int d  = ((int)list.get(j) - (int)list.get(i)); 
          
          if ( d == K ){ 
              tot++;
             j++;
          }
            else if ( d < K)
            {   
               j++;
            }
            else 
                i++;
          
          
      }
       
       System.out.println(tot);
       
    }
}
