
package graphdfs;

import java.util.*;



public class graph {
  static int ways=0;

 public static void main(String argsp[]){
     
     Scanner sc=new Scanner(System.in);
     int n = sc.nextInt();
     int m = sc.nextInt();
     int stash[]=new int[n+1];
     boolean visited[]= new boolean[n+1];
     
     ArrayList adjacent[]=new ArrayList[n+1];
     
     LinkedList q = new LinkedList();
     
       for(int i=1;i<=n;i++)
            adjacent[i]=new ArrayList();
       
     
     for(int i=1;i<=n;i++)
         stash[i] = sc.nextInt();
     
     for(int t=0;t<m;t++){
         int x= sc.nextInt();
         int y = sc.nextInt();
         
         adjacent[x].add(y);
         adjacent[y].add(x);
         
         
     }
     
     int max=0 ; 
     
     int loot=0;
     
     for(int i=1;i<=n;i++){
         if (!visited[i]){
            q.add(i);
            ways++;
            visited[i]=true;
            int looted[]=new int[2];
           // looted[0]=0; looted[1]=0;
            
            loot = BFS(q , visited , adjacent , stash , looted , 0 , max  );
          
            if (max < loot) max=loot;
            
         }
         
        // System.out.println("----"+max+" "+ways);
        
     }
     System.out.println(max+" "+ways);
     
 }

    private static int BFS(LinkedList q, boolean[] visited, ArrayList[] adjacent, int[] stash, int[] looted, int arr, int max) {
 
       if (q.isEmpty()){
            if (arr>0) ways++;
           return max;
       }
       
       //-------------------------
       
       int qs  = q.size();
       
       while(qs-- > 0){
            int node = (int)q.poll();
       
         visited[node]=true;
         looted[arr%2]+=stash[node];
       
           if (looted[arr%2] > max) 
                   max = looted[arr%2];
           
          for(int k=0; k<adjacent[node].size() ; k++){
               int adn =(int)adjacent[node].get(k);
        
                if (!visited[adn]) {
           //          System.out.print(adn+" "+ stash[node] );
                     q.add(adn);    
                 }          
           }
           
           
           
       }
       
       
       //-------------------------
     /*  
       int node = (int)q.poll();
       
         visited[node]=true;
         looted[arr%2]+=stash[node];
       
           if (looted[arr%2] > max) 
                   max = looted[arr%2];
               
         
       System.out.println("add of "+node+": ");
    */
  
       
     return BFS(q , visited , adjacent , stash , looted ,arr+1 , max);
    
    }

    
}
