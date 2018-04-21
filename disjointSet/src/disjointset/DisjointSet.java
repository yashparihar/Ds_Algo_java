
package disjointset;
/*DISJOINT SET USING 3 OP

  1.  QUICK FIND
  2. QUICK UNION
  3. WEIGHTED  QUICK UNION AND PATH COMPRESSION
*/

public class DisjointSet {

    public static class quickFind{
      int id[]; 
        
        quickFind(int n){
            id=new int[n];
            for(int i=0;i<n;i++){
                id[i] = i;
            }   
        }
        
        
        public boolean find(int p ,int q){
            return (id[p]==id[q]);
        }
        
        
        public void union(int  p ,int q){
            if (!find(p,q))
             {
                int pid = id[p];
                for(int i=0;i<id.length;i++){
                     if(id[i] == pid)
                          id[i] = id[q];
                }         
            }
        }
       
        public void display(){
            System.out.println();
            for(int i=0;i<id.length;i++){
                System.out.print(" "+id[i]);
            }
        }
    
  }
 //-------------------------------------------------------------------------------------------------------------
    
    public static class quickUnion{
      int id[]; 
        
        quickUnion(int n){
            id=new int[n];
            for(int i=0;i<n;i++){
                id[i] = i;
            }
            
        }
        
        public int root(int i){
            while (id[i]!=i){
                i = id[i];
            }
            return i;
        }
        
        public boolean find(int p ,int q){
           return root(p)==root(q);
        }
        
        public void union(int  p ,int q){
           if (!find(p,q)){
               int i = root(p);
               int j = root(q);
               id[i] = id[j];
           }
        }
       
        public void display(){
            System.out.println();
            for(int i=0;i<id.length;i++){
                System.out.print(" "+id[i]);
            }
        }
    
  }
    
    
  //---------------------------------------------------------------------------------------
    
    public static class WeightedquickUnion{
      int id[]; 
      int size[];
        
        WeightedquickUnion(int n){
            id=new int[n];
            size = new int[n];
            for(int i=0;i<n;i++){
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
    
 //---------------------------------------------------------------------------------------   
    
    public static void main(String[] args) {
        // TODO code application logic here
        int size = 10;
        WeightedquickUnion qu = new WeightedquickUnion(size);
        qu.display();
        qu.union(3, 4); qu.display();
        qu.union(4, 9); qu.display();
       qu.union(8, 0); qu.display();
       qu.union(2, 3); qu.display();
        qu.union(5, 6);  qu.display();

        qu.union(5, 9); qu.display();
        qu.union(7, 3);  qu.display();
        qu.union(4, 8);  qu.display();
        qu.union(6, 1);  qu.display();
//System.out.println("0 2  "+qu.find(0, 2) ); 
//System.out.println("2  4 "+qu.find(2, 4) ); 


qu.display();
        
    }
    
}
