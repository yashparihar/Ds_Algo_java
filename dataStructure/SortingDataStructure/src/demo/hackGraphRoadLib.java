
package demo;

import java.util.Scanner;




public class  hackGraphRoadLib {

    
    
    static class set{
        int n;
        int id[];
        int size[];
        
        set(int ne){
         n=ne;
         id=new int[n+1];
         size = new int[n+1];
         
         for(int i=1;i<=n;i++){
             id[i]=i;
             size[i]=1;
         }
        }
        
       public int root(int i){
            while(id[i]!=i){
                id[i]=id[id[i]];
                i=id[i];
            }
            return i;
        }
       
        public boolean findset(int i,int j){
           if (id[root(i)]==id[root(j)]) return true;
           else return false;
       }
       
       public boolean union(int i,int j ){
           
           if (!findset(i,j)){
               int rA = root(i);
               int rB  = root(j);
               
               if (size[rA] >= size[rB]){
                   id[rB] = id[rA];
                   size[rA]+=size[rB];
                   size[rB] = size[rA];
               }
               else{
                     id[rA] = id[rB];
                   size[rB]+=size[rA];
                   size[rA] = size[rB];
               }
               
               return true;
           }
           return false;
       }
        
       
       public void display(){
           System.out.println("-----------------------");
           for(int i=1;i<n;i++){
               System.out.println(id[i]+" "+size[i]);
           }
       }
     
    }
  
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            long lc =in.nextLong();
            long rc =in.nextLong();
            
             int x[]=new int[m+1];
            
             int y[]=new int[m+1];
      
      
               
      for(int i=1;i<=m;i++){
           x[i]=in.nextInt();
          y[i]=in.nextInt();
      }
      
      
     if (lc <= rc){
         long ans= n * lc;
         System.out.println(ans);
     }
     else{
    
         set setobj = new set(n+1);
         long totedge=0;
     
            for(int i=1;i<=m;i++){       
                 if (setobj.union(x[i], y[i])){
                    totedge+=1;
                 }
            }
//   setobj.display();
    
     long diff = n - totedge;
      //System.out.println("diff:"+diff ); 
      long ans = (lc * diff) + rc * totedge ; 
     System.out.println(ans);
     
     
     
     
     }    


            
            
            
        }
    }
}
