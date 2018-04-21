/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timedemo;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Timedemo {

  
    
 public static String getCurTime(){
     
       java.util.Date date = new java.util.Date();
       SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
       return sdf.format(date);
  }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
    
     //   double d=   Math.log(65)/Math.log(2);
       int i=1; 
       
        System.out.println("i++ : "+ (i++) +  
                " || ++i :" + (++i) +
                " || i "+ (i) +
                ", i++"+ (i++) );
     
        
    }
    
    
 
}