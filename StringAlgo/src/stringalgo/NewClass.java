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
public class NewClass {
    

    
       static int shr[];
       static int smin[];
       static int ehr[];
       static int emin[];
       
        
    static boolean checkCab(int i){
        
        
        
       boolean con=true;
        
        int temp= i-1;
        while(temp>=0){
            try{
            if  ( ( ( shr[i]>shr[temp] || 
                 ( shr[i]==shr[temp] && smin[i]>=smin[temp]  )  )  
               &&
                 ( ehr[i]<ehr[temp] || 
                  ( ehr[i]==ehr[temp] && emin[i]<=emin[temp] )  ) ) 
                || 
                ( ( shr[i]<shr[temp] || 
                 ( shr[i]==shr[temp] && smin[i]<=smin[temp]  )  )  
               &&
                 ( ehr[i]>shr[temp] || 
                  ( ehr[i]==shr[temp] && emin[i]>=smin[temp] )  ) )
               || 
                ( ( shr[i]<ehr[temp] || 
                 ( shr[i]==ehr[temp] && smin[i]<=emin[temp]  )  )  
               &&
                 ( ehr[i]>ehr[temp] || 
                  ( ehr[i]==ehr[temp] && emin[i]>=emin[temp] )  ) )
              || 
                ( ( shr[i]<shr[temp] || 
                 ( shr[i]==shr[temp] && smin[i]<=smin[temp]  )  )  
               &&
                 ( ehr[i]>ehr[temp] || 
                  ( ehr[i]==ehr[temp] && emin[i]>=emin[temp] )  ) ) )
                
                  con=false;
                  
                      
            }
            catch(Exception ex){
                System.out.println("i="+i+" temp="+temp);
            }
            
            temp--;
        }
        
        return con;
        
    }    
        
        
    public static void main(String args[] ) throws Exception {
       
      
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
       
     shr=new int[N];
     smin=new int[N];
      ehr=new int[N];
      emin=new int[N];
       
       
       int tot=0;
       
        for (int i = 0; i < N; i++) {
            shr[i] = s.nextInt();
            smin[i] = s.nextInt();
            ehr[i] = s.nextInt();
            emin[i] = s.nextInt();
            
            if (!checkCab(i))
               tot+=1;
            
            
            
        }
        
        System.out.println(tot);
        

    //    System.out.println("Hello World!");
    }
}
