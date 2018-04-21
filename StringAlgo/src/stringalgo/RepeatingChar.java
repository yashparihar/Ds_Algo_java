/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringalgo;

/**
 *
 * @author Yash
 */
import java.util.*;

public class RepeatingChar {
    
       static boolean op=false;
   //   static
     static boolean flg=true;
     static HashMap map = new HashMap();
     static int tot=0;
    
    public static void main(String arg[]){
        Scanner sc=new Scanner(System.in);
      String str =sc.next();
      
       int[] repeat=new int[str.length()];
      
      for(int i=0;i<str.length(); i++){
          //Set s = map.entrySet();
          
          if (!map.containsKey(str.charAt(i))){
              map.put( str.charAt(i) , tot );
              repeat[tot] = 1;
    //           System.out.println("first time:-"+str.charAt(i)+" "+tot+" repeat:"+repeat[tot]);
           
               
             
          }
          else{
              int ind = (int)map.get(str.charAt(i) );
              repeat[ind]+=1;
     //            System.out.println("Already their:-"+str.charAt(i)+" "+ind+" repeat:"+repeat[ind]);
           
             continue;
          }
          
          checkout(repeat  ) ;
          
        
          
           tot++;
      }
      tot++;
        checkout(repeat  );
          
        
      
      if (flg) System.out.println("YES");
      else System.out.println("NO");
    
    }

    private static void checkout(int[] repeat) {
   
          if (tot>1){
      //          System.out.println("tot:-"+tot);
              if ( repeat[tot-1]==repeat[tot-2]){
      //            System.out.println("op: same");
         //         continue;
              }
              else if (op==false && Math.abs(repeat[tot-1] - repeat[tot-2]) == 1 ){
         //         System.out.println("op: 1 diff");
                  if (repeat[tot-1]>repeat[tot-2]) repeat[tot-1]--;
                  else  repeat[tot-2]--;
                  op=true;
              }
              else if ( tot>=3 && (repeat[tot-1]==repeat[tot-2] || repeat[tot-1]==repeat[tot-3]) && op==true  ){
       //            System.out.println("op: check with 3");
          //         continue;
              }
              else if (repeat[tot-1]==1 && op==false) {
       //           System.out.println("op:prev alone");
                  repeat[tot-1]=0;
                  op=true;
                          }
              else if (tot>=2 && repeat[tot-2]==1 && op==false ) {
       //           System.out.println("op: prev prev alone");
                  repeat[tot-2]=0;
                  op=true;
                          }
              else{
        //          System.out.println("op: nothing");
                  flg=false;
                
              }
              
             
          }
    
    
    }
    
}
