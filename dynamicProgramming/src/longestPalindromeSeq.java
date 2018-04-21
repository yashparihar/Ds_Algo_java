
import java.util.*;
/*
TRANSFORM TO PALINDROME

given N range , no of pair E , and M letter in String
To find LONGEST COMMON SUBSEQUENCE in the string

Question: https://www.hackerrank.com/contests/w33/challenges/transform-to-palindrome

*/


public class longestPalindromeSeq {

  
    
    //WeightedquickUnion
     public static class set{
      int id[]; 
      int size[];
        
        set(int n){
            id=new int[n+1];
            size = new int[n+1];
            for(int i=1;i<=n;i++){
                id[i] = i;
                size[i] = 1;
            }
            
        }
        
        public int root(int i){
            while (id[i]!=i){
                id[i] = id[id[i]]; //FOR PATH COMPRESSION
                i = id[i];
            }
            return i;
        }
        
     
        
        public boolean find(int p ,int q){
           return root(p)==root(q);
        }
        
        public boolean union(int  p ,int q){
           if (!find(p,q)){
               int i = root(p);
               int j = root(q);
               
               if (size[i]<size[j]){
                   
                   id[i] = id[j];
                 //  id[i] = root(j);
                   size[j]+=size[i];
                   size[i]=size[j];
               }
               else{
                  id[j] = id[i];
                //   id[j] = root(i);
                  size[i]+=size[j];
                   size[j]=size[i];
               }
           return true;
           }
           return false;
        }
        
        
             public void display(){
            System.out.println();
            for(int i=0;i<id.length;i++){
                System.out.print(" "+id[i]);
            }
        }
        
     }
    
    
    public static void main(String args[]){
        
        
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
        int e=sc.nextInt();
        int m=sc.nextInt();
        
        int str[]=new int[m];
        int tab[][]=new int[m][m];
        char dir[][]=new char[m][m];
        
        set element=new set(n);
        
        for(int i=0;i<e;i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            
            element.union(x,y);
            
            
        }
        
     //   element.display();
        for(int i=0;i<m;i++){
             int x=sc.nextInt();
             str[i] = element.id[x];
          System.out.print(" "+str[i]);
         }
         
         int maxPalinSize=0;
         
        if (m != 0)  
       maxPalinSize = PalindromeSeq(str , tab , dir ); 
       System.out.println();
       System.out.println(maxPalinSize);
    }
    
    
    public static int PalindromeSeq(int str[], int tab[][] ,char dir[][]){
        int n = str.length;
       
        for(int i=0;i<n;i++){
            
            for(int j=0;j<n-i;j++){
                
                int x=j;
                int y=j+i;
               
                if (x==y) tab[x][y]=1;
                
                else if (str[x]==str[y]){
            //        System.out.println("same: "+x+" "+y);
                    tab[x][y] = 2 + tab[x+1][y-1];
                }
                else{
                //    System.out.println("diff: "+x+" "+y);
                    if (tab[x][y-1] >= tab[x+1][y]){
                        tab[x][y] = tab[x][y-1];
                        dir[x][y] = 'l';
                    }
                    else{
                          tab[x][y] = tab[x+1][y];
                        dir[x][y] = 'd';
                    }
                }    
                
                
                
            }
        }
        
        
        return tab[ 0 ][ n-1 ];
    }
    
    
    
    
     
    
}
