/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maths;

import java.util.*;

public class permuteCombi {

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
        
        int ans = fact(n) ;
        
        System.out.println(ans);
    }
    
    
    public static int fact(int n){
        if(n<=1) return 1;
        else 
            return n * fact(n-1);
    }
    
}

