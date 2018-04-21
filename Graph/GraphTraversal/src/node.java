
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;


public class node {
    
  public int id;
  public LinkedList adjacentList =new LinkedList<>();
  public LinkedList egdes =new LinkedList<edge>();
 //public edge edges[];
  public boolean visited;

  public node(){}
  
  public node(int id , int[] ls){
     this.id = id; 
      
    //  adjacentList =new LinkedList<Integer>();
      
     addAdjacentNode(ls); 
     
   //  edges= new edge[ls.length]; //Initialzing node total edges
     
     visited = false;
      
  }
  
  public void allocateEdgeSpace(int n){
    //   edges= new edge[n]; //Initialzing node total edges
  }
  
  public void addAdjacentNode(int a[]){
      Iterator it = Arrays.asList(a).iterator();
      while(it.hasNext()){
          adjacentList.add(it.hasNext());
      }
  }
  
  public void removeFirstAdjacentNode(){
      adjacentList.removeFirst();
  }
  
  public void getAllAdjacentNodes(){
       Iterator it = adjacentList.iterator();
      while(it.hasNext()){
          //adjacentList.add(it.hasNext());
          System.out.println("el "+it.hasNext() );
      }
  }
  
  
  public Integer getFirst(){ return (Integer) adjacentList.getFirst(); }
  
  
  
  
  
}

