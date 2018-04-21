
package graphdfs;

import java.util.*;

public class bishuNGirlfrd {

    
      static int girlFrds[];
      static ArrayList road[];
      static Stack stk;
      
   
      static int country;
      static TreeSet possGfCountry  = new TreeSet();
      static int prevAddedCountry;
    
    public static void main(String args[]){
        
        Queue que = new LinkedList();
        Scanner sc=new Scanner(System.in);

        country = sc.nextInt();  //GET NUM OF COUNTRIES
        
        road=new ArrayList[country+1]; // Being a tree , IT HAS TOT ROADS AS 1 LESS THAN NUM OF COUNTRY
        
        for(int i=1;i<=country;i++){
            road[i] = new ArrayList(); 
        }
        
        for(int i=1;i<country; i++){  //INPUTTING 2 COUNTRIES CONNECTED BT A ROAD
            int u = sc.nextInt();
            int v = sc.nextInt();
            
            road[u].add(v);
            road[v].add(u);
            
        }
        
        
        
        
        //no of girls
        int girls = sc.nextInt();
        girlFrds = new int[girls];
        
        //girls in country 
        for(int i=0;i<girls; i++)  
                girlFrds[i] = sc.nextInt();
        
        
        
        
        
        
        // adding root of  the tree
           que.add(1);

           possGfCountry.add(1001); //IT STORES ALL POSS COUNTRY WHERE GF OCCURS AT SAME DISTANCE
        // getting the nearest girlfrd
        findNearestGf(que);
       
        
        //GETTING THE LOWEST COUNTRIES BY ID WHERE GF RESIDES
        System.out.println(possGfCountry.first());
     
    }

    private static void findNearestGf(Queue que) {
  
        //if (stk.isEmpty()) return 0;
          if (que.isEmpty()) return;
          
        int cid;// = (int)que.poll(); //stk.pop();
        
        Queue newQue = new LinkedList();
        boolean flg=false;
        
        while(!que.isEmpty()){
            cid =(int)que.poll();
            
             for(int i=0; i<girlFrds.length ; i++){
                 if (cid == girlFrds[i]){
                    possGfCountry.add(cid);
                    prevAddedCountry = cid;
                    flg=true;
                    break;
                 }     
             }
             
             //IF NO COUNTRY SO FAR THAN ONLY CHECK FOR FUTHER COUNTRIES
             if (!flg){
                  for(int i=0;i<road[cid].size();i++){
                     //PUSHING ADJACENT COUNTRY CONNECTING THRU ROAD
                        newQue.add(road[cid].get(i));     
                  }
             }
         }
        
        //if any country found so far than get out...
        if (flg)  return;
    
        findNearestGf(newQue); 
        
        
    }
    
    
}

        
  
        
      
