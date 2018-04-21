
package graphdfs;

import java.util.*;


public class SnakeLadderBFS {
 
      
    
    
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        
         int t=sc.nextInt();
        
        
      for(int to=0;to<t;to++){  
     
        int square[]=new int[101];
        boolean visited[]=new boolean[101];
        int totstep[]=new int[101];
        LinkedList queue = new LinkedList();
        
        int ladder=sc.nextInt();
        
        for(int i=0;i<ladder;i++){
            square [ sc.nextInt() ] = sc.nextInt();
        }
        
        
        int snakes=sc.nextInt();
        
        for(int i=0;i<snakes;i++){
            square [ sc.nextInt() ] = sc.nextInt();
        }
        
        queue.add(1);
        visited[1] = true;
        
       int ans = BFS(queue , square , visited , totstep);
       System.out.println(ans); 
     }
    }

    private static int BFS(LinkedList queue, int[] square, boolean[] visited, int[] totstep) {
         if (queue.isEmpty()) return -1;
         
         int ele = (int)queue.poll();
        
         int gotstep=0;
         
       
         for(int i=6;i>0;i--){
             if ( (ele+i)>100 || visited[ele+i] )
                  continue;
                       
                 visited[ele+i] = true;
           
                 
                                       totstep[ele+i] = totstep[ele] + 1;      
                 if (square[ele+i]>0)  totstep[ square[ele+i] ] =  totstep[ele+i];
                 
              
              if (ele+i==100 || square[ele+i]==100){
                  gotstep = totstep[ele+i];
                   break;
              }
              
             if (square[ele+i] == 0)
                 queue.add(ele+i);
                 
             else{
                 queue.add(square[ele+i]);
                visited[ square[ele+i] ]=true ;
             }
          
         }
         
         
         if (gotstep>0) return gotstep;
         else
         return BFS(queue, square, visited, totstep);
    }
    
}
