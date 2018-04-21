/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerearth;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Yash
 */
public class MonkNIsland {
    
 
    
    public static void main(String args[]){
         //Scanner
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        for (int i = 0; i < t; i++) {
           int n = s.nextInt();
           int m = s.nextInt();
           
           ArrayList adjacent[] = new ArrayList[n+1];
              boolean visited[]=new boolean[n+1];
              
       /*   for(int k=1;k<=n;k++) {
              adjacent[k]=new ArrayList();
             // visited[k] = false;
          }
         */
       
           for(int j=0;j<m;j++){
                int x=s.nextInt();
                  int y=s.nextInt();
              
                if (adjacent[x]==null)
                    adjacent[x]=new ArrayList();
               
                if (adjacent[y]==null)
                    adjacent[y]=new ArrayList();
            
                adjacent[x].add(y);
                adjacent[y].add(x);
            
                        
           }
           Queue q=new LinkedList();
           q.add(1);
        
           int ans = bfs(n , q ,adjacent, visited) ; 
           
           System.out.println(ans-1);
        }
      
    }
    
    
    public static int bfs(int n , Queue q ,ArrayList adjacent[], boolean visited[]){
        
        if (q.isEmpty()) return 0;
        boolean flg=false;
        Queue q2 = new LinkedList();
        
        Object elem;
        
        while((elem=q.poll())!=null){
            int ele = (int)elem;
            
            if (ele==n) {
                 flg=true;
                 break;
            }
            
            for (Object ad : adjacent[ele]) {
                    if (visited[(int)ad]) continue;
                   
                    q2.add((int)ad);
                    visited[(int)ad] = true;
                
            }
            
         }
        
        if (flg)  return 1;
         else
        return 1 + bfs(n , q2 , adjacent , visited);   
    }
}
