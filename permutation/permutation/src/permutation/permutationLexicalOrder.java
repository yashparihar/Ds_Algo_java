/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package permutation;

import java.util.Arrays;
import java.util.Scanner;

public class permutationLexicalOrder {
    
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String str = sc.next();
        
        char strarr[] = str.toCharArray();
             
        while(true){
       
            int pivot = genPivot(strarr);
            
            if (pivot==-1)
                break;
            int ceil= genCeiling(strarr , pivot );
            
              
               
           swap(strarr , pivot , ceil); // System.out.println(new String(strarr));
            
           reverseStr(strarr , pivot+1, strarr.length-1);   
           
           System.out.println(new String(strarr));
            
         
        }
        
    
     }
   

    
    
    private static void reverseStr(char str[], int l, int r) {
   
        int diff = (r - l + 1) / 2;
     
        for(int i=0; i<diff ; i++){
            int le=l+i;
            int rg=r-i;
            swap(str ,le , rg );   
           
        }
        
       
    }

    
    
    private static void swap(char str[], int i, int j) {
    
         char temp = str[i];
           str[i] = str[j];
           str[j] = temp;

    }

    private static int genCeiling(char[] strarr, int pivot) {
            int ceil =  strarr.length-1;
            while(ceil>=0 && strarr[ceil]<=strarr[pivot]){
                ceil= ceil -1;
            }
            return ceil;
    }

    
    private static int genPivot(char[] strarr) {
          int pivot = strarr.length-1;
            
            while( pivot>0 && strarr[pivot] <= strarr[pivot-1]){
                pivot=pivot - 1;
            }
            pivot = pivot -1;
            
           return pivot; 
    }
    
    
}
