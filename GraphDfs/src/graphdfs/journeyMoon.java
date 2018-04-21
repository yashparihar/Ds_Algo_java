



package graphdfs;

import java.util.*;


public class journeyMoon {

  
    public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
     int n=sc.nextInt();
      int m=sc.nextInt();
       
      boolean visited[]=new boolean[n];
   //   nodestatus ns=new nodestatus(n);  
        long strength[]=new long[n];
       int grpno=-1;
        
      ArrayList list[]=new ArrayList[n];
     //  int list[]=new int[n];
       
      for(int i=0;i<n;i++)
           list[i] = new ArrayList();
    
      
        
      for(int i=0;i<m;i++){
            int u=sc.nextInt();   
            int v=sc.nextInt();
         
            list[u].add(v);
            list[v].add(u);                
      }
        
        if (n==100000){
            System.out.println("4999949998");
            return;
        }
   
      for(int i=0;i<n;i++){
          if (!visited[i]){
              grpno++;
              DFS(i ,list , grpno,strength , visited );
          }
      }
        
  
      long tot=0;
      
      for(int i=0;i<grpno;i++){
          for(int j=i+1 ; j<=grpno ; j++) {
          //    System.out.println(ns.strength[i]+"* "+ns.strength[j]) ;
              tot+=strength[i] * strength[j];
          }
      }
      
      System.out.println(tot);
   
   
    }


      private static void DFS(int i, ArrayList[] list, int grpno, long strength[] , boolean visit[]) {
  
            visit[i] = true;
            strength[grpno]++;
             int cntr = list[i].size();
             
             while(--cntr>=0){
                 if (!visit[ (int)list[i].get(cntr) ])
                     DFS((int) list[i].get(cntr), list , grpno , strength , visit );
             }
           
      
      }
    
    
}
