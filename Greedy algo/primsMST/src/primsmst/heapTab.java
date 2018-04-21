
package primsmst;

//HEAP TAB CONTAINS NODE THAT ARE YET TO PUT IN MST
public class heapTab {
 
     nodeRelation nodeR[];
    int size;
    int capacity;
    
    public heapTab(int s ){
        nodeR = new nodeRelation[s];
        size=s;
        capacity = s;
    }
    public void initializeHeapWithRoot(int no){
        for(int i=0;i<capacity;i++){
            if (i==no) nodeR[i]=new nodeRelation(i , -1 , -1);
            else  nodeR[i]=new nodeRelation(i);
        }
    }
    
    
    
    public void minHeapify(int i){
        int l = left(i);
        int r = right(i);
        int smallest=i;
        if ( l<size && nodeR[l].cost < nodeR[i].cost )
           smallest = l;
      
        if ( r<size && nodeR[r].cost < nodeR[smallest].cost)
         smallest = r;
    
        if (smallest!=i){
            nodeRelation temp = nodeR[i];
            nodeR[i] = nodeR[smallest];
            nodeR[smallest] = temp;
            
            minHeapify(smallest);
        }
        
    }
    
    
    
    
    
    public nodeRelation extractMin(){
        nodeRelation minNum=new nodeRelation();
        if (size==0)
            return minNum;
        else if (size==1){
            minNum = nodeR[0];
            size--;
            return minNum;
        }
        
        minNum = nodeR[0];
        nodeR[0] = nodeR[size - 1];
        size--;
        
        minHeapify(0);
        
        return minNum;
        
    }
    
    
    
    
      public int getPos(int ide){
          int posi =-1;
          for(int i=0;i<size;i++){
              if (ide== nodeR[i].id) posi= i; 
          }
          
          return posi;
      }
    
    
  public void decrease(int ide , int parenti , int newcost){
           
           
           int pos = getPos(ide);
          
         
           System.out.println("node: "+parenti+" its adjacent "+nodeR[pos].id+" oldcost:"+ nodeR[pos].cost+" newcost: "+newcost);
       
             if (nodeR[pos].cost < newcost) return;
           
           nodeR[pos].cost  = newcost;
        nodeR[pos].parentId = parenti;
        int i= pos;
        
        
       while(parent(pos) > -1 && nodeR[pos].cost < nodeR[parent(pos) ].cost ) {
         //   System.out.println("yes pos:"+pos);
             nodeRelation temp =nodeR[pos] ;
             nodeR[pos] = nodeR[ parent(pos) ];
             nodeR[parent(pos)] = temp;
             
             pos = parent(pos);
             
        }
    //    nodeR[i].parentId=pos;
        System.out.println("sucessfully decreased: "+pos);
           
    }
    
    
    
    
    
    
    
      public void displayall(){
        System.out.println("Min number= "); int no=0;
      while(no<size){
      System.out.println(" "+nodeR[no].toString()); no+=1;
      }
    }
    
    
      
         public int parent(int i){
        return ( (i-1) / 2 );
    }
    public int left(int i){
        return ( (i*2) + 1);
    }
    public int right(int i){
        return ( (i*2) + 2);
    }
    
    public int getMin(){
        return nodeR[0].id;
    }
}
