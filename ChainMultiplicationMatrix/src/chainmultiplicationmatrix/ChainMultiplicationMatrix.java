
package chainmultiplicationmatrix;

import java.util.Scanner;

public class ChainMultiplicationMatrix {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        
        int p[]={40, 20, 30, 10, 30} ;
        /*
         A(10*20) , B(20,30) , C(30,40) , D(40,50)
        
        */
        
        
          int N=p.length;      //sc.nextInt();
      
        int M[][]=new int[N-1][N-1];
        int K[][]=new int[N-1][N-1];
        
        int totMul=0;
        
        for(int i=0;i<N-1;i++){
         for(int j=0; (j+i+1)<(N-1) ; j++ ){
             int x = j;
             int y= j+i+1;
             
             
            totMul = getMinMulti(M,K,p,x,y); 
        
         } 
        
       }
        
       System.out.println("Min multiplication : "+totMul);
        System.out.println("Printing  : ");
      
       printingParenthesis(K ,  0 , N-2);
       
       
       
     /*  for(int i=0;i<N-1;i++){
               System.out.println();
               
           for(int j=0;j<N-1; j++){
               System.out.print(" "+M[i][j]);
           }
           
       }
       */ 
    }

    private static int getMinMulti(int[][] M, int[][] K,int p[], int x, int y) {
        if (x==y){
            M[x][y]=0;
            return 1;
        }
        
        int k=x;
        int finalK=k;
        int sum=90000;
        
        while(k<y){
            int tempsum = M[x][k] + M[k+1][y] + p[x]*p[k+1]*p[y+1]; 
         //System.out.println("when k="+k+" tempsum="+tempsum);
            if (tempsum < sum){
                finalK=k;
                sum = tempsum;
                
                M[x][y] = sum;
                K[x][y] = k;
            }
            
            k = k+1;
        }
        
        return sum;
    }

    private static void printingParenthesis(int[][] K, int x, int y) {
     
       if (x==y){
           System.out.print("Mat"+x);
           return;
       }
       
       int kemp = K[x][y];
       System.out.print("( ");
       
       printingParenthesis(K , x , kemp );
       
       printingParenthesis(K , kemp+1 , y );
       
        System.out.print(") ");
    
    }
    
}
