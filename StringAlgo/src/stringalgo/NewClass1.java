/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringalgo;

import java.util.*;

/**
 *
 * @author Yash
 */
public class NewClass1 {

    
   public static HashMap weigth;// = new HashMap();
   public static ArrayList adjacent[];
   public static boolean visited[];
    
    public static class subtree{
      public int h , w;
      subtree(){
          h=0; w=0;
      }
    }
    
    public static void main(String args[] ) throws Exception {
  
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
       
        for (int i = 0; i < T; i++) {
           int n=s.nextInt();
           visited=new boolean[n+1];
           adjacent= new ArrayList[n+1];
           weigth = new HashMap();
           
           for(int lo=1; lo<n+1 ; lo++)
              adjacent[lo] = new ArrayList();
           
           for(int j=0;j<n-1;j++){
               int x = s.nextInt();
               int y = s.nextInt();
               int w = s.nextInt();
               
               adjacent[x].add(y);    adjacent[y].add(x);
               weigth.put(x+" "+y , w);
               weigth.put(y+" "+x , w);
               
           }
           
         //  System.out.println("ws="+weigth.size()+" totn="+adjacent.length );
            subtree max1 = new subtree(); 
            subtree max2 = new subtree(); 
            visited[1] = true;
            for(Object adNode : adjacent[1]){
                int ad = (int)adNode;
                visited[ad]=true;
                subtree npath = maxPath(ad , (int)weigth.get(1+" "+ad));
                
                if (npath.h > max1.h){
                    max2 = max1;
                    max1 = npath;
                }
                else if ( (npath.h == max1.h) && (npath.w > max1.w) ){
                    max2 = max1;
                    max1 = npath;
                }
                else  if (npath.h > max2.h)
                    max2 = npath;
                
                else if ( (npath.h == max1.h) && (npath.w > max1.w) )
                    max2 = npath;
                
                
            }
            
            int maxp=(max1.w+max2.w);
            int c=0;
            /*
            If maximum distance is <100, cost = 0.
If maximum distance is > 100, cost = 100.
If maximum distance is > 1000, cost = 1000.
If maximum distance is > 10000, cost = 10000.
            */
            if (maxp > 10000)  c=10000;
            else if (maxp > 1000)  c=1000;
            else if (maxp > 100)  c=100;
            else c=0;
            
            System.out.println(c+" "+maxp );
            
            
        } 
        
      }
      
      public static subtree maxPath(int node ,int w ){
          
          subtree max = new subtree();
      //    System.out.println("in node:"+node);
          
          for(Object ob : adjacent[node]){
              int ad = (int)ob;
             //   System.out.println(" its adn="+ad);
              if (visited[ad]) continue;
      //          System.out.println(" aft its adn="+ad);
              visited[ad] = true;
              
              subtree pathDist = maxPath( ad , (int)weigth.get(node+" "+ad) );
              
              if (pathDist.h > max.h)
                  max = pathDist;
              else if (pathDist.h==max.h && pathDist.w>max.w)
                  max = pathDist;
              
          }
          
           max.w += w;
           max.h++;
           return max;
          
      }
      
      
    }


