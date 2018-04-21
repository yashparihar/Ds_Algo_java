
package PractOS.lru_pagereplacement;

import java.util.Scanner;

public class LRU_pageReplacement {

    public static boolean checkNewAlreadyExist(int page, int buffer[]){
       boolean flg=false;
        for(int i=0;i<buffer.length;i++){
            if (page==buffer[i]){
                flg=true;
                break;
            }
        }
       /* if(flg) System.out.println("Yes their");
        else System.out.println("noo their");  */
        
        return flg;
    }
    
    
    public static int[] updateSortedBuffer(int data,int buff[]){
        int i=0;
        for(;i<buff.length-1;i++){
            buff[i]=buff[i+1];
        } 
        buff[i]=data;
        
        return buff;
        
    }
    
    
    public static void displaybuffer(int buffer[]){
        for(int i=0;i<buffer.length;i++){
            System.out.print(buffer[i]+" ");
        }
    }
    
    public static int[] swapUpdate(int buffer[],int data,int p){
        int i=0;
        for(i=0;i<=p;i++){
            if (buffer[i]==data) break;
        }
        
        for(;i<p  ;i++){
            buffer[i]=buffer[i+1];
        }
        buffer[p]=data;
        
        return buffer;
    }
    
    
    public static void main(String[] args) {
       
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter buffer size: ");
        int buffersize=4;  //sc.nextInt();
        
        int buffer[]=new int[buffersize];
        int sortedBuffer[]=new int[buffersize];
        
       // int page[]={7,9,1,2,9,3,9,4,2,3,9,3,2,1,2,9,1,7,9,1};
       
        int page[]={1,2,3,4,1,2,5,1,2,3,4,5};
        int p=-1;
     //  System.out.println("enter pages: ");
       
       int fault=0;
       
      /*  for(int i=0;i<page.length;i++){
                page[i]=sc.nextInt();
        }*/
        
        for(int i=0;i<page.length;i++){

             if ( checkNewAlreadyExist(page[i],buffer) ) {
                  sortedBuffer=swapUpdate(sortedBuffer, page[i], p );
                    continue;
             }
             
             
             else if (p!=buffersize-1){
                p++;
                buffer[p]=page[i];
                sortedBuffer[p]=page[i];
                
          //      System.out.println("after updating sortedbuffer "); displaybuffer(sortedBuffer);
            }
            else if (p==buffersize-1){

                int k=0;
             //    System.out.println("findind least recently element: ie "+sortedBuffer[0]);
                for(k=0;k<buffersize;k++){
                    if (sortedBuffer[0]==buffer[k])
                        break;
                }
                
                
           //   System.out.println("the least recentedly data "+buffer[k]);
              
          //     System.out.println("replaced that old element with new ele:"+page[i] );
              buffer[k]=page[i];
          //     System.out.println("before updating sortedbuffer");   displaybuffer(sortedBuffer);
               
               sortedBuffer=updateSortedBuffer(page[i],sortedBuffer);  
           //     System.out.println("after updating sortedbuffer "); displaybuffer(sortedBuffer);
                
                  // put data at that position with least recently used
                
                System.out.println("A Page Fault");
                
                fault++;
                
            }
             
            System.out.println("page element: "+page[i]+" => " ) ; 
            displaybuffer(buffer);
            
             
        }
        
        System.out.println("Page fault: "+fault);
        
         displaybuffer(buffer);
        
        
    }
    
}
