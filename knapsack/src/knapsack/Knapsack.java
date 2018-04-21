
//KNAPSACK - GREEDY APPROACH.....................

package knapsack;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class Knapsack {

    
    public static class item{
        int no;
        float w;
        float v;
        float den;
        
        item() {
          }
        
        item(int no,float w,float v){
            this.no=no;
            this.w=w;
            this.v=v;
            this.den=v/w;
        }
        

    }
    
    public static class resultItem extends item{
        float totalw=0;
        float benefit=0;
        
        
     resultItem(int no,float w,float v, float tw, float b){
        super(no, w , v);
        totalw=tw;
        benefit=b;
      }
     
    }
    
   public static class heap{
       item it[];
       int capacity;
       int size;
       
       heap(int n){
           it=new item[n];
           capacity=n;
           size=0;
       }
       
       void insert(item Item){
        
           if(size>capacity){
               return;
           }
         
           it[size]=Item;
           
           int i=size;
           
           while(i>0 && it[i].den > it[(i-1)/2].den){
               swap(i ,(i-1)/2 );
             // item temp=it[i];
              
               i=(i-1)/2;
           }
           
           size++;
           
       }
       
       item extractmax(){
           item res=null;
           
           if (size==0){
               return res;
           }
           
           res=it[0];
           
           size=size-1;
           
           
           it[0]=it[size];
           
           
           maxheap(0);
           
           return res;
       }
       
     private void maxheap(int cnt) {
      
         int i=cnt;
         int max=i ;
         int l=(i*2)+1;
         int r=(i*2)+2;
         if (l<=size && it[max].den < it[l].den )
             max = l;
         
         if (r<=size && it[max].den < it[r].den )
             max = r;
         
         if (max!=cnt){
             swap(max,cnt) ;
             
             maxheap(max);
             
         }
         
                     
     }
         

        private void swap(int i, int j) {
           item temp=it[i];
           it[i]=it[j];
           it[j]=temp;      
        }

      
   }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
             
        Scanner sc=new Scanner(System.in);
    
        int capacity=sc.nextInt();
        
        int n=sc.nextInt();
     
        heap sortedList=new heap(n);
       
        for(int i=0;i<n;i++){
            System.out.println("for item "+(i+1));
            float w=sc.nextInt(); 
            float v=sc.nextInt();
            
          sortedList.insert( new item(i,w,v) );
           
    }
        
        
      System.out.println("sorted order size: "+sortedList.size);
          


     resultItem result[] = new resultItem[n];  //RESULTSET TABLE LENGTH SET
     float totw=0;
     float benefit=0;
     int i=0;
     
     
     //MAIN ALGO------------------------------------------
      while(i<n && totw<capacity){
          item temp=sortedList.extractmax();
          float tw=0;
          float ben=0;
          
          if (totw+temp.w > capacity){
              tw = ( capacity - totw);
              ben = tw * temp.den;
          }

          else{
              tw = temp.w;
              ben = temp.v;
          }
          
          totw+=tw;
          benefit+=ben;
          result[i]=new resultItem(temp.no,temp.w,temp.v, totw, benefit);
          
          
          i++;
      }
      //MAIN ALGO......END..............................................
      
      
      //Result TABLE PRINT........................
        int cnt=0;
      while(cnt<i){
      
          System.out.println(result[cnt].no+" "+result[cnt].totalw+" "+result[cnt].benefit);
          cnt=cnt+1;
      }
     

   
    }
    
}
