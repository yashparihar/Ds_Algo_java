
import java.util.*;

public class oliverBattle {

public static void main(String args[]){
    
    Scanner sc=new Scanner(System.in) ;
    int t=sc.nextInt();
 
    
    for(int i=0;i<t;i++){
        int n=sc.nextInt();  
        int m=sc.nextInt();
        int field[][]=new int[n][m] ;
        boolean visited[][] = new boolean[n][m] ;
        int cell[]=new int[2];
        
       
        Queue q = new LinkedList() ;
        for(int x=0;x<n;x++){
            for(int y=0;y<m;y++){
                field[x][y] = sc.nextInt();
            }       
        }
        
         
         int batIndex=0;
         int battalion[]=new int[(n*m)];
         int max=0;
       for(int x=0;x<n;x++){
            for(int y=0;y<m;y++){
              
                if (field[x][y]==1 && !visited[x][y]) {
                   
                    cell[0]=x;  cell[1]=y;
                    
                    q.add(cell );
                    visited[x][y]=true;
                
                    battalion[batIndex] =  assignAdjacent(field , visited , q );
                    
                    if (battalion[batIndex] > max) max = battalion[batIndex];
                    //System.out.println("tottrop:"+tottrop);
                   batIndex++;
                }
            }
        
        }
        System.out.println(batIndex+" "+max); 
        
    }
    
    
}

    private static int assignAdjacent( int[][] field, boolean visited[][], Queue q) {
        //int tropSize=1;     
       if (q.isEmpty()) return 0;
       int cell[];
      
       Queue q2 = new LinkedList();
        int tot=0;
        
     while( ( cell=(int[]) q.poll())!=null){
         
         tot++;
       int n=cell[0]; int m=cell[1];
  
       if (m+1<field[0].length ) {
            if ( field[n][m+1]==1 && !visited[n][m+1]){
                 int newC[]={n , m+1};
                 q2.add(newC);  
                  visited[n][m+1]=true;  
            
            }
        }
       
       if (n+1<field.length ){
            if ( field[n+1][m]==1 && !visited[n+1][m]){
                 int newC[]={n+1 , m};
                  visited[n+1][m]=true;  
                 q2.add(newC);
            
            }
        }
           
         if (n+1<field.length && m+1<field[0].length ) {
             if (field[n+1][m+1]==1 && !visited[n+1][m+1]) {
                 int newC[]={n+1 , m+1};
                  visited[n+1][m+1]=true;  
                 q2.add(newC);
        
             }
         }
         
        if (n+1<field.length && m-1>=0 ) {
             if (field[n+1][m-1]==1 && !visited[n+1][m-1]) {
                 int newC[]={n+1 , m-1};
                  visited[n+1][m-1]=true;  
                 q2.add(newC);
         
             }
         }
        
        if ( m-1>=0 ) {
             if (field[n][m-1]==1 && !visited[n][m-1]) {
                 int newC[]={n , m-1};
                  visited[n][m-1]=true;  
                 q2.add(newC);
         
             }
         }
        
         if (n-1>=0 && m-1>=0 ) {
             if (field[n-1][m-1]==1 && !visited[n-1][m-1]) {
                 int newC[]={n-1 , m-1};
                  visited[n-1][m-1]=true;  
                 q2.add(newC);
         
             }
         }
         
          if ( n-1>=0 ) {
             if (field[n-1][m]==1 && !visited[n-1][m]) {
                 int newC[]={n-1 , m};
                  visited[n-1][m]=true;  
                 q2.add(newC);
         
             }
         }
          
          if ( n-1>=0 && m+1<field[0].length ) {
             if (field[n-1][m+1]==1 && !visited[n-1][m+1]) {
                 int newC[]={n-1 , m+1};
                  visited[n-1][m+1]=true;  
                 q2.add(newC);
         
             }
          }                    
       }
  
     return tot + assignAdjacent( field,  visited, q2);       
    }

}
