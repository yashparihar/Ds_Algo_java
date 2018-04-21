/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Yash
 */

public class simplSorting {

    private static void swap(int[] ele, kth kobj, int i) {
  
      int temp = ele[kobj.index];
      ele[kobj.index] = ele[i];
      ele[i] = temp;
      
      kobj.index = i;
    }

    private static void display(int[] ele) {
 
      for(int i=0;i<ele.length ; i++){
          System.out.print(" "+ele[i]);
      }
    }
    
    
    public static class kth 
    {
        int index;
        int val;
        
        kth(){}
        kth(int i,int v){
            index = i;
            val = v;
        }

     
    }
    
    static class sortt implements Comparator<Object>{

        @Override
        public int compare(Object o1, Object o2) {
         kth a = (kth) o1;
         kth b = (kth) o2;
         
         if (a.val < b.val) return 1;
         else 
             return -1;
        
        }
        
        
        
    }

public static void main(String args[]){
   
   sortt srt = new sortt();
   
    Scanner sc=new Scanner(System.in);
    
    int ele[]=new int[5];
    kth kobj[]=new kth[5];
    
    for(int i=0;i<5;i++){
     
        ele[i] = sc.nextInt();
        kobj[i] = new kth(i , ele[i]);
        
    }
    
    Arrays.sort(kobj, srt);
    
    for(int i=0;i<5;i++){
        
        System.out.println("ind:"+kobj[i].index+" val:"+kobj[i].val);
    }
    
   int i=0; 
   int j=0;
   int k=1;
   
   while(j<k){
       if (kobj[i].index != i){
           swap(ele , kobj[i] , i);
           j++;
       }
       i++;
   }
   
   System.out.println();
  display(ele);
    
}
    
}
