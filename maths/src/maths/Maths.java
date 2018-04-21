    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maths;

import java.math.BigInteger;
/**
 *
 * @author Yash
 */ import java.util.*;
public class Maths {

   
    public static void main(String[] args) {
       
       Scanner sc=new Scanner(System.in);
       int n= sc.nextInt();
       int v[]=new int[n];
       
       int p[]=new int[n];
       
       for(int i=0;i<n;i++)
         v[i] = sc.nextInt();
         
       for(int i=0;i<n;i++)
       {      p[i] = sc.nextInt();
       }
      Arrays.sort(p ) ;
      Arrays.sort(v);
      boolean flg=true;
      for(int i=n-1;i>=0;i--){
          if(v[i] <= p[i]){
              flg=false;
              break;
          }
          
          
          
      }
      
      
      if (flg)
      System.out.println("Yes");
      else
           System.out.println("No");     
              
      
      
    //  String 
    String st = sc.next();
    
    if (st.charAt(2)=='r'){
        
    }
   
    }
    
}
