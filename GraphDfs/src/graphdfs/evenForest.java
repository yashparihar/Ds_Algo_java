
package graphdfs;

import java.util.*;


public class evenForest {
   
    static int tot=0;
    
    public static void main(String argsp[]){
        
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        
        ArrayList list[] = new ArrayList[n+1];
        Stack stk = new Stack();
        boolean visited[]=new boolean[n+1];
        
        for(int i=1;i<=n;i++)
            list[i]=new ArrayList();
        
        for(int i=0;i<m;i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            
            list[x].add(y);
            list[y].add(x);
        }
        
        stk.push(1);
        visited[1]=true;
        DFS(list , stk , visited );
        
        
        System.out.println(tot-1);
        
    }

    private static int DFS(ArrayList[] list, Stack stk, boolean[] visited ) {
     
        if (stk.isEmpty()) return tot;
    
         int res = 1;
         
         int ind = (int)stk.pop();
         ArrayList node = list[ind];
         //System.out.println("poped "+ind);
         for(int i=0;i<node.size() ; i++)
         {
            int ele = (int)node.get(i);
             if (!visited[ele]){
                 stk.push(ele);
           //      System.out.println("pushed "+ele);
                 visited[ele]=true;
                 res = res + DFS(list , stk , visited );
             }   
         }
         
         if (res%2==0){
             res=0;
        //     System.out.println("discharge ");
             tot+=1;
         }
         
         return res;
         
         
    }
}
