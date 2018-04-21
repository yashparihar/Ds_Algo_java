/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringalgo;

import java.util.Scanner;

/**
 *
 * @author Yash
 */
public class StringAlgo {
 
 
    
    public static void main(String[] args) {
    
        
        Scanner sc=new Scanner(System.in);
        String element = sc.next();
        
        int i=-1;
        int max=0;
        int zeros=0 ,ones=0;
        boolean kemp = false;
        int poss[]=new int[element.length()];
        
        
        for(int t=0; t<element.length() ;  t++){
            
            if (element.charAt(t)=='0'){
                
                if ( i>=0 && max < poss[i] &&  !kemp)
                    max = poss[i];
                
                if (!kemp){
                    i++;
                    poss[i]=ones+1;
                    kemp = true;
                    ones = 0;
                    
                }
                else
                    poss[i]++;
                
                zeros++;
             //   System.out.println("0="+t);
            }
            
            else{
                if (i==-1) i=0;
                
                kemp=false;
                poss[i]++;
                ones++;
                
             //   System.out.println("1="+t);
            }
            
        }
        
        
        if (max < poss[i]) max = poss[i];
        
        if (max < zeros) max = zeros;
        
        
        System.out.println(max);
        
        
        
        
 }
}
