
package graphdfs;


//BREATH FIRST SEARCH PROBLEM......

import java.util.*;

public class bfsShortest {
    
    
    public static void main(String args[]){
        
        Scanner sc=new Scanner(System.in);
        LinkedList q=new LinkedList();
       
        int n=sc.nextInt();
        int m=sc.nextInt();
        int visitSize[]=new int[n+1];
        
        ArrayList list[]=new ArrayList[n+1];
        
        for(int i=1;i<=n;i++)
            list[i]=new ArrayList();
        
        for(int i=0;i<m;i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            list[x].add(y);
            list[y].add(x);
            
        }
        
         int source= sc.nextInt();
         
         q.add(source);
      //   visitSize[source]=-1;
         
         BFS(list , q , visitSize);
       
         for(int i=1;i<=n;i++){
             if (i==source) continue;
             int vs = visitSize[i];
             if (vs > 0)
                 System.out.print((6*vs)+" ");
             else if (vs==0)
                 System.out.print("-1 ");
         }
         System.out.println();
    }

    private static void BFS(ArrayList[] list, LinkedList q, int[] vs) {
 
        if (q.isEmpty()) return;
        
        int node = (int)q.poll();
     //   System.out.println("poped: "+node);
        ArrayList l = list[node];
        
        for(int i=0; i<l.size() ; i++){
             int ele =(int)l.get(i);
            
             if (vs[ele] > 0 )
                   continue ; 
           
              q.add(ele);
        //      System.out.println("added: "+ele);
              vs[ ele ]=1 + vs[ node ] ;
        }
        
        BFS(list , q , vs);
    }
    
}
