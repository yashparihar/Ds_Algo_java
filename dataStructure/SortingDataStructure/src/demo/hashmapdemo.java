
package demo;

import java.util.*;
import java.util.HashMap;

import java.util.Scanner;

public class hashmapdemo {


    public static void main(String args[]){
     
       ArrayList lis = new ArrayList();
       
        
        HashMap ele= new HashMap();
        
 
      int N,M;
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        
        for(int i=0;i<N;i++){
            int e= sc.nextInt();
            
            if (ele.get(e)==null)
                ele.put(e, 1);
            else {
                int n = (int)ele.get(e)+1;
                ele.replace(e, n);
            }
        }
        
       M=sc.nextInt();
       
       for(int i=0;i<M;i++){
           int e=sc.nextInt();
           
          if ((ele.get(e)==null) || ((int)ele.get(e)==0)) {
              lis.add(e);
              ele.replace(e, -1);
            
           }
           else{
               ele.replace(e, (int)ele.get(e)-1 );
               
           }
           
       }
       
       Collections.sort(lis);
      
       for(int i=0;i<lis.size();i++)
           System.out.print(lis.get(i)+" ");
    }
    
}
