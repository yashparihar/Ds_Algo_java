/*
  Find the longest path in a matrix with given constraints
Given a n*n matrix where all numbers are distinct, find the maximum length path (starting from any cell) such that all cells along the path are in increasing order with a difference of 1.

We can move in 4 directions from a given cell (i, j), i.e., we can move to (i+1, j) or (i, j+1) or (i-1, j) \\

http://www.geeksforgeeks.org/find-the-longest-path-in-a-matrix-with-given-constraints/



*/
import java.util.*;

public class longestPathInMat {

 public static void main(String args[]){
     
     Scanner sc=new Scanner(System.in);
     
  /*   char mat[][] = {   { 'q' , 'l' , 'i' , 'h' , 'i'} ,
                        { 'k' , 'k' , 'j' , 'g' , 'j'} ,
                        { 'r' , 'b' , 'c' , 'f' , 'p'} ,
                        { 'i' , 'k' , 'd' , 'e' , 'a'} ,
                        { 'a' , 'a' , 'b' , 'w' , 'l'} 
                    } ;
    */
  
  
     char mat[][] = { { 1 , 6} , 
                       {7 , 9}  
                   };
  
     
     int rows = mat.length;
     int cols = mat[0].length;
     int steps[][]=new int[rows][cols];

    int maxPath = lookPath( mat , steps , rows  , cols);     
     
    System.out.println(maxPath);    
 }
 
 
  public static int lookPath(char mat[][] , int steps[][] , int rows , int cols){
      
      int maxpath=0;
      
      for(int i=0;i<rows ; i++){
          for(int j=0;j<cols ; j++){
              if (steps[i][j]!=0) continue;
             
              int temp=0;
              if ( (temp = checkPath(mat,steps , i , j)) > maxpath) 
                  maxpath = temp;
          
          }
      }
      
      return maxpath;
  }

    private static int checkPath(char[][] mat, int[][] steps, int i, int j) {
   
        int rows=mat.length;
        int cols=mat[0].length;
        
        int max=1;
        
        if (j+1<cols && mat[i][j+1]-mat[i][j]==1 ) {
            steps[i][j] = 1 +  checkPath( mat , steps , i , j+1 );
            if (max<steps[i][j]) max =steps[i][j];
        }
        
         if (  j-1>=0 && mat[i][j-1]-mat[i][j]==1 ){
            steps[i][j] = 1 +  checkPath( mat , steps , i , j-1 );
            if (max<steps[i][j]) max =steps[i][j];
         }
        
         if (i+1<rows && mat[i+1][j]-mat[i][j]==1){
            steps[i][j] = 1 +  checkPath( mat , steps , i+1 , j );
            if (max<steps[i][j]) max =steps[i][j];
         }
         
         if (  i-1>=0 && mat[i-1][j]-mat[i][j]==1 ){
            steps[i][j] = 1 +  checkPath( mat , steps , i-1 , j );
            if (max<steps[i][j]) max =steps[i][j];
         }
        
        return (steps[i][j] = max );
        
        
    }
 
     
 }
    

