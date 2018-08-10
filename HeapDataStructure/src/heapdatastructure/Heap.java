
// package heapdatastructure;

import java.util.LinkedList;

public class Heap {

   int number[];
    int size;
    int capacity;
    
    //getmin
    //extract min
    //delete(i)
    //decrease(pos , val)
    //minheap
    
    public Heap() {}
    
    public Heap(int s){
        size = -1;
        capacity = s;
        number = new int[s];
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
        return number[0];
    }
    
    public void insert(int i){
        size++;
        int no=size;
        number[no] = i;
        
        while(no>0 && number[no] < number[ parent(no) ]  ){
            int temp= number[no];
            number[no] = number[parent(no)];
            number[parent(no)] = temp;
            no = parent(no);
        }
    }
    
    public void minHeapify(int i){
        int l = left(i);
        int r = right(i);
        int smallest=i;
        if ( l<size && number[l] < number[i] )
           smallest = l;
      
        if ( r<size && number[r] < number[ smallest ] )
         smallest = r;
    
        if (smallest!=i){
            int temp = number[i];
            number[i] = number[smallest];
            number[smallest] = temp;
            
            minHeapify(smallest);
        }
        
    }
    
    
    public void decrease(int pos , int value){
        number[pos] = value;
        int i= pos;
        
        while(pos > 0 && number[pos] < number[ parent(pos) ] ) {
             int temp = number[pos];
             number[pos] = number[ parent(pos) ];
             number[parent(pos)] = temp;
             
             pos = parent(pos);
        }
        
    }
    
    public int extractMin(){
        int minNum=-1;
        if (size==0)
            return -1;
        else if (size==1){
            minNum = number[0];
            size--;
            return minNum;
        }
        
        minNum = number[0];
        number[0] = number[size - 1];
        size--;
        
        minHeapify(0);
        
        return minNum;
        
    }
    
    public int deleteKey(int i){
        decrease(i , -1);
        return extractMin();
    }
    
    public void displayall(){
        System.out.println("Min number= "); int no=0;
      while(no<size){
      System.out.print(" "+number[no]); no+=1;
      }
    }
   
    
    
}
