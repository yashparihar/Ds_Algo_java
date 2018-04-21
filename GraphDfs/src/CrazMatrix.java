
/*

HACKEREARTH PROBLEM: CRAZY MATRIX..
TO USE CONCEPT OF DFS


*/


import java.util.*;


public class CrazMatrix {

   
    static int N;// = s.nextInt();
       static int mat[][];//=new int[N][N];
       static boolean visited[][];//=new boolean[N][N];
       static Stack st;// = new Stack();
    
    
    public static class pos{
        public int x , y;
        pos(){}
        pos(int i,int j) {  x=i; y=j ; }
    
    }
    
    public static void main(String args[] ) throws Exception {

        //Scanner
        Scanner s = new Scanner(System.in);
        N = s.nextInt();
        mat=new int[N][N];
        visited=new boolean[N][N];
         st = new Stack();
        

        for (int i = 0; i < N; i++) {
           for(int j=0;j<N ;j++){
                mat[i][j] = s.nextInt();       
           }
        }
        
            for(int i=0;i<N;i++){
                if (mat[0][i]==1) st.push(new pos(0,i) ) ; 
            }
             
        boolean cond1 = dfs( 1);
        
          st.clear();
            for(int i=0;i<N;i++){
                if (mat[i][0]==2) st.push(new pos(i,0) ) ;
            }
        
        
        boolean cond2 = dfs(2);
        
       // System.out.println(cond1+" "+cond2);
        
        if (cond1 && !cond2)  System.out.println("1");
        else if (!cond1 && cond2)  System.out.println("2");
        else if (cond1 && cond2)  System.out.println("AMBIGUOUS");
        else System.out.println("0");
    }
    //.................
    static boolean dfs( int cond){
        
        if (st.isEmpty()) return false;
        boolean flg=false;
        pos ele = (pos)st.pop();
        
        int x = ele.x; int y = ele.y; 
        
        if (cond==1){
           if (adjacentCond1(x,y) && (x+1==N-1))
             flg = true;
        }
        else {
           if (adjacentCond2(x,y) && (y+1==N-1))
              flg=true;
        }
        
        if (flg) return true;
        else
                 return dfs(cond);

    }
    //..................................
    public static boolean adjacentCond1(int x, int y){
          boolean flg=false;
          
         
          
        if (x+1<N){
             flg = ( viable(x+1,y,1) || flg ) ;
            
            if (y+1<N){
             flg = flg || viable(x+1 , y+1 , 1);
            flg = ( viable(x,y+1,1) || flg ) ;

            }
            if (y-1>=0){
              flg = flg || viable(x+1 , y-1 , 1);
               flg = ( viable(x,y-1,1) || flg ) ;
            }
               
        }
        return flg;  
    
    }
    //.........................................
    public static boolean adjacentCond2(int x, int y){
          boolean flg=false;
          
     
           
          
        if (y+1<N){
             flg = (flg || viable(x,y+1,2)) ;
            
            if (x+1<N) {
              flg = flg || viable(x+1 , y+1 , 2);
              flg = ( viable(x+1,y,2) || flg ) ;
            }
            if (x-1>=0){
              flg = flg || viable(x-1 , y+1 , 2);
              flg = ( viable(x-1,y,2) || flg ) ;
            }
               
        }
        return flg;  
    
    }
    
    
    
    public static boolean viable(int x ,int y , int v){
        if (!visited[x][y] && mat[x][y]==v) {
             st.push(new pos(x , y));
                visited[x][y]=true;
            return true;    
        }
        return false;
    } 
    
    
    
}
