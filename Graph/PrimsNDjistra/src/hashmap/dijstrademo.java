
package hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 class adjacentnode{
    public ArrayList<Integer> to= new ArrayList<Integer>();//
    public ArrayList<Integer> cost = new ArrayList<Integer>();//
     
     int size;
    
     public adjacentnode(){  size=0; }
     public void addEle(int t,int c){
         to.add(t);
         cost.add(c); size++;
     }
     @Override
     public String toString(){
         if (!to.isEmpty())
         return "adNodes:"+to.toString()+" its cost:"+cost.toString();
         else
             return "Empty";
     }
    
   }

  class nodeRelation{
      int node; int parentnode ; int cost;
      public nodeRelation(){}
      public nodeRelation(int n,int p , int c){
          parentnode=p;  node=n; cost=c;
      } 
      @Override
      public String toString(){
          return "node:"+node+" parent:"+parentnode+" cost:"+cost;
      }
  }

   class MinHeapNode{
       nodeRelation node[];
       int size;
       int capacity;
       
       public MinHeapNode(){}
       public MinHeapNode(int totalNode){
           capacity=totalNode+1;
           node=new nodeRelation[capacity]; 
           size=capacity;
       }
       public void initializeRoot(int root){
           
             node[1]=new nodeRelation(root,-1,0);  //KEEPING THE ROOT ELE AT TOP
             
           for(int i=2,v=1 ; i<capacity ; v++){   //AND REST AS IT IS
               if (v!=root){
                             
                   node[i]=new nodeRelation(v,-1,999999);
                   i++;
               }
           }
       }
       public void display(){
           for(int i=1;i<size;i++){
               System.out.println(node[i].toString());
           }
       }
     
       public void minheapify(int root){
           int l = root*2 ;
           int r = root*2 + 1 ;
           int small = root;
           if( l<size && node[small].cost > node[l].cost ) 
               small = l;
           if ( r<size && node[small].cost > node[r].cost )
               small = r;
           
           if (small!=root){
               nodeRelation temp = node[small];
               node[small]  = node[root];
               node[root] = temp;
               
               minheapify(small);
           }
           
       }
       
       public nodeRelation extractMin(){         

                     nodeRelation exEle = node[1];
                     
                     if (size==1){
                         return exEle;
                     }
                     else if (size==2)   { 
                     // node[0]= node[size-1];
                      size--;
                     return exEle;              
                    }
                  
                     
               node[1]= node[size-1];
                      size--;
           //          return exEle;        
           
               minheapify(1);
           
                    return exEle;
       }
       
       public int getNode(int nodee){
           int cnt=0;
           for(int i=1;i<size;i++){
               if (nodee==node[i].node) {
                   cnt = i;
                   break;
               }
           }
           return cnt;
       }
       
       public int parent(int i){     return i/2;        }
       
       public void decrease(int toNode , int fromNode , int newcost){
           int nodeCounter = getNode(toNode);
      //     System.out.println("ad node: "+node[nodeCounter].node);
           if (node[nodeCounter].cost <= newcost) {return; }
           node[nodeCounter].cost = newcost;  node[nodeCounter].parentnode = fromNode;
           int pos = nodeCounter;
           while(pos>1 && node[pos].cost < node[parent(pos)].cost){
               nodeRelation temp = node[pos];
               node[pos] = node[parent(pos)];
               node[parent(pos)] = temp;
               pos = parent(pos);
           }
           
           
           
       }
       
       
   }
*/

public class dijstrademo {
    
  
   
   
    public static void main(String args[]){
        
        Scanner sc= new Scanner(System.in);
        
   //     int casee = sc.nextInt();
        
        
   // for(int c=0;c<casee;c++){
        
       int size = sc.nextInt();
       int edge = sc.nextInt();
        boolean nodeDone[]=new boolean[size+1];
       int costToReach[] = new int[size+1];
       HashMap<Integer,adjacentnode> adjacent = new HashMap<Integer,adjacentnode>();
        
       for(int i=0;i<edge;i++){
           int x =sc.nextInt();
           int y= sc.nextInt();
           int cost= sc.nextInt();
           
           if (!adjacent.containsKey(x) ) {
               adjacent.put(x, new adjacentnode());
           }
      /*     if (!adjacent.containsKey(y) ) {
               adjacent.put(y, new adjacentnode());
           }
        */       
               
          //   adjacent.get(0).to.add(y);    adjacent.get(0).cost.add(cost);
         adjacent.get(x).addEle(y, cost);
     //    adjacent.get(y).addEle(x, cost);
       } 
        
       int root = sc.nextInt();
       
    //   for(int i=1;i<=size;i++){
    //       System.out.println("node "+i+" adjacent nodes and size: "+adjacent.get(i).toString());
    //   } 
     
       MinHeapNode nodes = new MinHeapNode(size+1);
       nodes.initializeRoot(root);
      int ver=1;
      int totalWeight=0;
      
      
      
      
      while(ver<=size){
        //  nodes.display();
          nodeRelation min = nodes.extractMin();
          
          nodeDone[min.node]=true; 
          costToReach[min.node] = min.cost;
      //   System.out.println("Extracted:"+ min.toString()+ "noddes in heap:"+nodes.size);
         totalWeight+= min.cost;
          adjacentnode adjnode = adjacent.get(min.node);
       //   System.out.println("adjacent: "+adjnode.toString());
        
          
          for(int i=0;i<adjnode.size ; i++){
       //        System.out.println(" "+adjnode.to.get(i));
              if (nodeDone[adjnode.to.get(i)]==false){
                  nodes.decrease(adjnode.to.get(i) , min.node , min.cost ,adjnode.cost.get(i) );
              }
          }
          ver+=1;
      }
       
      // System.out.println(totalWeight);
       
      for(int i=1;i<=size;i++){
         if (i!=root) System.out.print(costToReach[i]+" ");
       }
        
        
      
  //  }
    
    }
}
