
package kruskal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Kruskal {

  

    public static class edge{
        int vertex1;
        int vertex2;
        int weight;
        
        public edge(){}
        public edge(int v,int u,int w){
            vertex1=v;
            vertex2=u;
           weight=w;
        }
    }
    
    //-----------------------------------------------------------------------------
    public static class SortedEdge{
        edge edges[];
        int size;
        int index;
        
        public SortedEdge(){}
        public SortedEdge(int n){
            index=1;
            size = n+1;
            edges=new edge[n+1];
        }
        
        public void addEdge(edge e){ //CREATED HEAP
            edges[index] = e;
          
            edge e_a = e;
            int ecnt=index;
            while(ecnt>1 && edges[ecnt].weight < edges[ecnt/2].weight){
                edge temp = edges[ecnt];
                edges[ecnt] = edges[ecnt/2];
                edges[ecnt/2] = temp;
                ecnt = ecnt/2;
                
            }
            
              index+=1;
        }
        
        public edge extractMin(){
            edge e=edges[1];
            if (size==1) return e;
            
            else if  (size==2){
                size=1; 
               return e;
            }
           
               edges[1] = edges[size-1];
                size=size-1; 
                
               minheap(1); 
                
               return e;
           
        }

        private void minheap(int i) {
           int l = i * 2;
           int r = i*2 + 1;
           int small=i;
           
           if(l<size && edges[small].weight > edges[l].weight){
               small = l;
           }
           if(r<size && edges[small].weight > edges[r].weight){
               small = r;
           }
           
           if (small!=i){
               edge e = edges[small];
               edges[small] = edges[i];
               edges[i] = e;
               minheap(small);
           }
        }

     
        
        
    } 
    
    
    //--------------------------------------------------------------------------------------------------------
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
    
    //---------------------------------------------------------------------------------------------------------
    
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc=new Scanner(System.in);
        
        int n =4;// sc.nextInt();
        int e =6;//sc.nextInt(); 
        SortedEdge edgeHeap = new SortedEdge(e);
        
        inputSampleA(edgeHeap);  //EDGE=6 NODE=4
     //    inputSampleB(edgeHeap); //EDGE=11 NODE=7
   //         for(int i =0;i<e;i++){        
    //       edgeHeap.addEdge(new edge( sc.nextInt() , sc.nextInt() , sc.nextInt() ) );
     //  }

        int totalW=0; 
        ArrayList mst = new ArrayList<edge>();
        
        WeightedquickUnion wqu = new WeightedquickUnion(n+1);
     //   System.out.println(edgeHeap.size);
       edge ed;//=edgeHeap.extractMin();   
        do{
            ed=edgeHeap.extractMin();
           // wqu.display();
          // System.out.println( " size:"+edgeHeap.size+" ; "+(ed.vertex1-1)+" "+(ed.vertex2-1) );
            if (wqu.union(ed.vertex1-1 , ed.vertex2-1)){
                totalW+=ed.weight;
                mst.add(ed);
            }
            
          } while(edgeHeap.size!=1);
        
        
        System.out.println("-----------------------");
        Iterator it = mst.iterator();
        while( it.hasNext()){
            edge es= (edge)it.next();
            System.out.println(" "+es.vertex1+" "+es.vertex2+" "+es.weight); 
            
        }
             
             
    }
    
    
    
      private static void inputSampleA(SortedEdge edgeHeap) {
       
       edgeHeap.addEdge(new edge(1,2,5));
        edgeHeap.addEdge(new edge(1,2,3));
        edgeHeap.addEdge(new edge(4,1,6));
        edgeHeap.addEdge(new edge(2,4,7));
        edgeHeap.addEdge(new edge(3,2,4));
        edgeHeap.addEdge(new edge(3,4,5));
    }
      
      
        private static void inputSampleB(SortedEdge edgeHeap) {
       
       edgeHeap.addEdge(new edge(1,2,7));
       edgeHeap.addEdge(new edge(1,4,5));
       edgeHeap.addEdge(new edge(2,3,8));
       edgeHeap.addEdge(new edge(2,5,7));
       edgeHeap.addEdge(new edge(2,4,9));
       edgeHeap.addEdge(new edge(3,5,5));
       edgeHeap.addEdge(new edge(4,5,15));
       edgeHeap.addEdge(new edge(4,6,6));
       edgeHeap.addEdge(new edge(5,6,8));
       edgeHeap.addEdge(new edge(5,7,9));
       edgeHeap.addEdge(new edge(6,7,11));
    }
    
}
