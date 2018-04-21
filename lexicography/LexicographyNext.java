/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author Yash
 */
public class LexicographyNext {

    static char[] swapFromTo(char[] arr,int pos){
        int nextPos=100;
        int count=0;
        for(int i=pos+1;i<arr.length;i++){
            // System.out.println("diff of i n pos: "+(arr[i]-arr[pos]));
            if ( arr[i]-arr[pos] < nextPos && arr[i]-arr[pos] >0){
              nextPos=arr[i]-arr[pos];
              count=i;
        }
            
        }
        //System.out.println("next Greater than "+arr[pos]+" found is "+arr[count]+" nextpos: "+nextPos);
        char temp=arr[pos];
        arr[pos]=arr[count];
        arr[count]=temp;
        
        
        return arr;
    }
    
    
     static char[] sortFromTo(char[] arr,int pos){
         for(int i=arr.length;i>pos;i--){
             for(int j=pos;j<i-1;j++){
                 if(arr[j]>arr[j+1]){
                     char temp=arr[j+1];
                     arr[j+1]=arr[j];
                     arr[j]=temp;
                 }
             }
         }
         
         return arr;
     }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc=new Scanner(System.in);
        String srt=sc.next();
        
        System.out.println("String is: "+srt);
        
        int len=srt.length();
        char[] c_char=srt.toCharArray();
        
       
       // for(int no=0;no<50;no++){
        boolean flg=false;
        
        for(int i=c_char.length-1;i>0;i--){
            
            if(c_char[i]>c_char[i-1]){
                System.out.println("found "+ c_char[i]+" > "+c_char[i-1]);
                flg=true;
                c_char=swapFromTo(c_char,i-1);
              //   System.out.println("after swaping str: "+new String(c_char));
                c_char=sortFromTo(c_char,i);
                
                System.out.println("after sorting str: "+new String(c_char));
            }
           
            
       }
     /*   if (flg==false){
            break;
        }*/
        
        
        
    //abcd    System.out.println("total combination: "+lp);
    }
    
}
