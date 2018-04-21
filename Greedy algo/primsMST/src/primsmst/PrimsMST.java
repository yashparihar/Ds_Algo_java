
package primsmst;

import java.util.Arrays;
import java.util.Iterator;


public class PrimsMST {


    public static void main(String[] args) {
        // TODO code application logic here
        int size=9; // NO OF VERTICES
         
        //IN THIS THOSE VERTICES REMAINS THAT ARE TO BE INCLUDED IN MST .. INITIALLY ALL VERTICES ARE IN THIS 
        heapTab heap = new heapTab(size);            //HEAP THAT MANAGES EDGES IN HEAP ORDER
        
        //IN THIS THOSE VERTICES ARE THAT ARE INCLUDED IN MST
        nodeRelation MSTTab[] =new nodeRelation[size];//HERE REAL MST RESULT IS STORED
        
       NODE node[]=new NODE[size];                  //NODES AND ITS ADJACENT NODES
    
       
         //-  INPUT ALLOCATES NODES,ITS ADJACENT NODE-COST 
      // sampleExampleA(node); //SIZE 5
     //  sampleExampleB(node); //SIZE 6
       sampleExampleC(node);   //SIZE 8  

       
      boolean nodeDone[] = new boolean[size];  //TRACKS THAT NODES THAT ARE IN MST IE EXTRACTED
        
        
        //INITALIZE HEAP WITH ROOT 0
        heap.initializeHeapWithRoot(0);
        
        heap.displayall();  //BEFORE COMMENCING PRIMS
        
  
    int ver=0;   //no of vertices
    NODE nod =node[0];  //NODE OBJECT
    
    //LOOP TILL ALL VERTICES ARE TRACKED
        while( ver<size )
        {
         //  System.out.println("---------");
          
            //MINIMUM I.E ROOT NODE IS REMOVED FROM HEAP AN STORED IN MST AND TEMP 
           nodeRelation min = heap.extractMin();  
           
           //STORED EXTRACTED NODE IN MST 
           MSTTab[ver] = min; 
           
           nod = node[ min.id ];  //GETS NODE DETAILS OF EXTRACTED NODE AN STORE IN NODE OBJECT
           
           nodeDone[nod.id]=true; //AS EXTRACE NODE IS DONE SO IT IS FLGED AS DONE
           
         //  System.out.println("heap extract min: "+nod.id+ " and size:"+ nod.adjacentnode.size());
          
           //NOW EXTRACTED NODES ADJACENT NODES ARE TRACED
           Iterator it = nod.adjacentnode.iterator();
           while(it.hasNext()){  //LOOP TILL ALL ADJACENT NODES ARE TRACED
                 //STORES ADJACENT NODE
                 adjacentNode ad = (adjacentNode) it.next();
                 
               //ONLY TRACE THOSE ADJACENT NODES WHICH ARE STILL AVAILABLE AND ARE NOT EXTRACT BEFORE  
                if (nodeDone[ad.id]==false){   
                                                                                 // System.out.println("Its adjacent: "+ad.toString());             
                  //NODE AND THESE ADJACENT NODES COST IS PASSED AND THEIR CHECK IF COST OS LESS THEN EXISTING THEN PDATES ELSE RETURN AS IT IS
                    heap.decrease(ad.id , nod.id , ad.cost);  //( AdjacentNode, ParentNode , their Cost)
                                                                                         //System.out.println("Its adjacent: "+ad.toString());                
               }
           }
           ver+=1;  
        }  //OUT WHEN ALL VERTICES ARE CHECKED
        
      //DISPLAY ALL NODES DETAILS IN MST ........
         for(int i=0;i<size;i++){
             System.out.println(" "+MSTTab[i].toString());
         }
        
    }

    
    
    
    
    private static void sampleExampleA(NODE[] node) {
       int adA[][] ={ {1,3,4},{3,7,1} };
        int adB[][] ={ {0,4,2,3}, {3,6,5,2} };
        int adC[][] ={ {1,4} , {5,4} };
        int adD[][]= { {1,0} , {2,7} };
        int adE[][]= { {0,1,2}, {1,6,4} };
        
        System.out.println("size="+adB[0].length);
        
        node[0] = new NODE(0 , adA);
        node[1] = new NODE(1 , adB);
        node[2] = new NODE(2 , adC);
        node[3] = new NODE(3 , adD);
        node[4] = new NODE(4 , adE);
    }

    private static void sampleExampleB(NODE[] node) {
         int adA[][] ={ {1,4,5},{16,19,21} };
        int adB[][] ={ {0,2,5,3}, {16,6,11,5} };
        int adC[][] ={ {1,3} , {6,10} };
        int adD[][]= { {2,4,5,1} , {10,14,18,5} };
        int adE[][]= { {0,3,5}, {19,14,33} };
        int adf[][] = { {0,1,3,4}, {21,11,18,33}  };
        
         node[0] = new NODE(0 , adA);
        node[1] = new NODE(1 , adB);
        node[2] = new NODE(2 , adC);
        node[3] = new NODE(3 , adD);
        node[4] = new NODE(4 , adE);
         node[5] = new NODE(5 , adf);
    }

    private static void sampleExampleC(NODE[] node) {
        int adA[][] ={ {1,7},
                      {4,8} };
        int adB[][] ={ {0,2,7},
                       {4,8,11} };
        int adC[][] ={ {1,3,5,8} ,
                       {8,7,4,2} };
        int adD[][]= { {2,4,5} ,
                       {7,9,14} };
        int adE[][]= { {3,5},
                      {9,10} };
        int adf[][] = { {2,3,4,6},
                       { 4,14,10,2}  };
        int adg[][] = { {5,7,8},
                       {2,1,6}  };
        int adh[][] = { {0,1,6,8},
                      {8,11,1,7}  };
        int adi[][] = { {2,6,7},
                        {2,6,7}  };
        
         node[0] = new NODE(0 , adA);
        node[1] = new NODE(1 , adB);
        node[2] = new NODE(2 , adC);
        node[3] = new NODE(3 , adD);
        node[4] = new NODE(4 , adE);
         node[5] = new NODE(5 , adf);
         node[6] = new NODE(6 , adg);
         node[7] = new NODE(7 , adh);
         node[8] = new NODE(8 , adi);
    }

   
    
}
