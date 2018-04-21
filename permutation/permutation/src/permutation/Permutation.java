/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package permutation;

import java.util.Scanner;

public class Permutation {

    
    public static void permute(String str,int s , int e){
        if (s==e){
            System.out.println(str); 
            return;
        }
        
        for(int i=s;i<=e;i++){
          //  System.out.println("in loop: s:"+s+" i:"+i);
           str = swap(str,s,i);
             permute(str ,s+1 , e);
           
           str =swap(str,s,i); //BACKTRACKING - Getting to parent
            
           
                
        }
        
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc=new Scanner(System.in);
        String str =  sc.next();
        permute(str,0,str.length()-1);
    }

    private static String swap(String str, int s, int i) {
       char[] cArr = str.toCharArray();
      char temp = cArr[s];
      cArr[s] = cArr[i];
      cArr[i] = temp;
      
      return String.valueOf(cArr);
    }
    
}
