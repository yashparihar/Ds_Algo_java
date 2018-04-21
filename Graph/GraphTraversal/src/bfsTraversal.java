
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import static java.util.Spliterators.iterator;


public class bfsTraversal {
    
    
    public static void main(String args[]){
  
    Scanner sc=new Scanner(System.in);
      LinkedList allEdges = new LinkedList<edge>();
    LinkedList ls =new LinkedList();   
    LinkedList finalMst = new LinkedList<edge>();
    
    System.out.println("Enter total vertices:-");
    int n =6;// sc.nextInt();
    
    node A[] = new node[n]; //Total number of node is DECLARED
      
      System.out.println("Enter Nodes adjacent nodes and coresponding cost:-");
      
      for(int i=0;i<A.length;i++){   System.out.println();
          A[i]=new node();  //Every node is allocated space..
          A[i].id=i+1;      //node has id number representing
        
          
          
          
          
         //DYNAMIC INPUT---------------------------------- 
        /*  System.out.print( (i+1)+":- " );
          int no=0;
          int j=0;
          
          //Entering the adjancent nodes AND COST
          while(true){
              System.out.print(" node:");
               no = sc.nextInt() ;  //ENTER ADJACENT NODE ID
              if (no<1 || no>n) break;
              A[i].adjacentList.add( no );
              
              System.out.print(" , cost: ");
            A[i].egdes.add(sc.nextInt());  //ENTER CORRESPONDING COST
          } 
                  */
          

      }
      
      
      //STATIC INPUT--------------------------
      A[1].adjacentList.add(2);  A[1].egdes.add( new edge(1,3,2) );
      A[1].adjacentList.add(4);  A[1].egdes.add( new edge(1,7,4 ));
      A[1].adjacentList.add(5);  A[1].egdes.add(new edge(1,1,5 ));
      
      A[2].adjacentList.add(1);  A[2].egdes.add(new edge(2,3,1 ) );
      A[2].adjacentList.add(3);  A[2].egdes.add( new edge(2,5,3 ));
      A[2].adjacentList.add(4);  A[2].egdes.add( new edge(2,2,4 ));
      A[2].adjacentList.add(5);  A[2].egdes.add( new edge(2,6,5 ));
      
      A[3].adjacentList.add(2);  A[3].egdes.add(new edge(3,5,2 ));
      A[3].adjacentList.add(5);  A[3].egdes.add( new edge(3,4,5 ));
      
      A[4].adjacentList.add(2);  A[4].egdes.add( new edge(4,2,2 ));
      A[4].adjacentList.add(1);  A[4].egdes.add( new edge(4,7,1 ));
      
      A[5].adjacentList.add(1);  A[5].egdes.add( new edge(5,1,1 ));
      A[5].adjacentList.add(2);  A[5].egdes.add(new edge(5,6,2 ));
      A[5].adjacentList.add(3);  A[5].egdes.add(new edge(5,4,3 ));
     
   
      
       
        LinkedList nodeUsed = new LinkedList();
      nodeUsed.add(1);
         int node=0; int currNode=1;
        
       for(int i=1;i<A.length;i++){   System.out.println();
  
     
      
       do{
         //  int edgeSize=allEdges.size() - 1;
         int adjacentNode=0;
         while(adjacentNode < A[currNode].egdes.size() && currNode<n){
             System.out.println( (currNode)+" :: "+ A[currNode].egdes.get(adjacentNode).toString());
              allEdges.add( A[currNode].egdes.get(adjacentNode) );
              sortAllEdges( allEdges , nodeUsed);
              adjacentNode++;
         }
         
         System.out.println(" allEdges: "+allEdges.toString()+" nodeused:"+nodeUsed.toString());
         
           node++; // if (allEdges.size()==0) break;
           edge ed = (edge) allEdges.getFirst();
           
         currNode =ed.toId - 1;   //= getSmallestCostEdge(allEdges , nodeUsed) - 1;
         nodeUsed.add(currNode);
         
         System.out.println(" cURR NODE: "+currNode);
         
         
     }while(nodeUsed.size()<n);
       
       }    
    }

    private static void displayAdjacentList(node A) {
        
        Iterator it=A.adjacentList.iterator();
          while(it.hasNext()){
              System.out.print(" "+it.next() ) ;
              
          }
           System.out.println(" |  Correspoding edges:-");
        //  for(int i=0;i<A.egdes.size() ; i++){
              System.out.print(" "+A.egdes.toString());
         // }
    }

    private static void sortAllEdges(LinkedList allEdges, LinkedList nodeUsed) {
        int size= allEdges.size() ;
        int fixsize=size;
        edge key = (edge) allEdges.get(fixsize-1); 
         System.out.println("Size: "+size + "key:"+ key.cost);
        while(size > 0){
          edge ckA = (edge) allEdges.get(size-1);//
          System.out.println("cka:-"+ckA.cost+" key:-"+key.cost);
            if ( ckA.cost > key.cost ){

                System.out.println("possible");
                allEdges.set(size, ckA);
                              
            }
            else { break; }
            
        //   System.out.println(" "+allEdges.get(size).toString());
            size-=1;
        System.out.println("after size "+size);
        }
        
        allEdges.set(size-1, key);
    //    System.out.println("afet sorting: "+ allEdges.toString());
     //  if (!nodeUsed.contains(key.fromId)) nodeUsed.add(key.fromId);
     //  if (!nodeUsed.contains(key.toId))   nodeUsed.add(key.toId);
    }

    private static int getSmallestCostEdge(LinkedList allEdges, LinkedList nodeUsed) {
        edge fetchNode = (edge) allEdges.getFirst();
        while (nodeUsed.contains(fetchNode.toId)){
            System.out.println(+fetchNode.toId+" already contains");
           allEdges.removeFirst();
             
            fetchNode = (edge) allEdges.getFirst();
        }
        nodeUsed.add(fetchNode.toId);
         return fetchNode.toId;
    }
    
    
}
