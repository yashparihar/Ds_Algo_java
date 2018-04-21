
package heapdatastructure;

import java.util.Arrays;


public class HeapDataStructure {

  
    public static void main(String[] args) {
        // TODO code application logic here
        Heap heap = new Heap(8);
        
        heap.insert(7); 
        heap.insert(3);
        heap.insert(1);
        heap.insert(9);
        heap.insert(5);
        heap.insert(2);
        heap.insert(6);
        heap.insert(10);
        
        heap.displayall();
        heap.decrease(5, 1); //DECREASE
  heap.displayall();
  
  System.out.println("Delete 3rd :"+ heap.deleteKey(2)); //DELETE
   heap.displayall();
  
  System.out.println("Extract min= "+ heap.extractMin()); //EXTRACT MIN
   heap.displayall();
   
   
    System.out.println("Extract min= "+ heap.extractMin());
   heap.displayall();
   
   System.out.println("min no: "+heap.getMin());
        
        
        
    }
    
}
