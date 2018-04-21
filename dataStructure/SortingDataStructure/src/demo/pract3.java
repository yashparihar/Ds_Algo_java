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
public class pract3 {
    
    
    public static void main(String args[]){
        
        Scanner sc=new Scanner(System.in);
        int N = sc.nextInt();
      //  String res="";
        int no = N;
      /*  while (true){
            if (no%3 == 0){
                for(int i=0;i<no/3;i++)
                    res = "555"+res;
              break;   
            }
            else if (no%5 == 0){
                 no = no-5;
                 res = res+"33333";
               
            }
            else {
                if (no<5 || no==7) {
                    res="-1";
                    break;
                }
                else{
                    no = no-3;
                     res = "555"+res;
                }
            }
        }*/
      
      int rem = no%3;
      while(rem%5!=0){
          rem+=3;
      }
      
      for(int i=0;i<(N-rem);i++)
          System.out.print(5);
      for(int i=0;i<(rem);i++)
          System.out.print(3);
      
        
     //   System.out.println(res);
        
    }
}
/*
5
72574
97624
22881
52292
1650
*/
