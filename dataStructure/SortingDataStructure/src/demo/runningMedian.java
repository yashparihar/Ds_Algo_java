//RUNNING MEDIAN USING HEAP

package demo;

import java.util.PriorityQueue;
import java.util.*;


public class runningMedian {


public static void main(String args[]){
   Scanner sc=new Scanner(System.in);
    int N=sc.nextInt();
    
       PriorityQueue max = new PriorityQueue(N , Collections.reverseOrder());
    PriorityQueue min = new PriorityQueue();
  
 //   if (max.peek()==null)
   // System.out.println(max.peek());
    for(int i=0;i<N;i++){
        int no=sc.nextInt();
        if (max.peek()!=null)
            addelement(max , min ,no );
        else
            max.add(no);
    
        balanceHeap(max , min);
    }
    
    if (max.size() > min.size())
        System.out.println("max bigger "+max.poll());
    else if (min.size() > max.size())
        System.out.println("min big:"+ min.poll());
    else
        System.out.println("same: "+ ((int)max.poll()+(int)min.poll())/2 );
    
}    

    private static void addelement(PriorityQueue max, PriorityQueue min, int ele) {
       if (ele < (int)max.peek())
           max.add(ele);
     else
           min.add(ele);
    }

    private static void balanceHeap(PriorityQueue max, PriorityQueue min) {
       PriorityQueue big = (max.size()> min.size()) ?  max :min;
       PriorityQueue small = (max.size()>min.size()) ?  min:max;
       
       if (big.size() > small.size()+1)
           small.add( big.poll() );
  
    }
}
