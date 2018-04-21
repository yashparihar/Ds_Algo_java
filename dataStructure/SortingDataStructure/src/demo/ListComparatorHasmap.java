
package demo;

import java.util.*;

public class ListComparatorHasmap  {

   static class elements implements Comparable<elements>{
       String id;
       int no;
       static List<String> allid=new ArrayList<String>();
       
       static HashMap<String,elements> allEle = new HashMap<String,elements>();
       
       elements(){}
       elements(String i,int n){
           id=i;
           no=n;
           allid.add(id);
         
       }
       
       static void addElement(elements el){
           allEle.put(el.id , el);
       }
       
       
       
       @Override
       public String toString(){
           return id+":"+no+" ; ";
       }

        @Override
        public int compareTo(elements o) {
         
            if (this.no > o.no) return 1;
            else return -1;
        }
        
        public static void removeElement(String i){
            allid.remove(i);
            allEle.remove(i);
        }
        
        public static elements getElement(String i){
            return allEle.get(i);
        }
        
        public static String printAllId(){
            return allEle.toString();  //allid.toString();
        }
       
       
   }
    
   static class FuelPriority
    implements Comparator<Object>
{

    @Override
    public int compare(Object o1, Object o2)
    {

        elements a1 = (elements)o1;
        elements a2 = (elements)o2;

        return Integer.compare(a1.no , a2.no);
    }
}
    
    public static void main(String[] args) {
        // TODO code application logic here
        FuelPriority strategy = new FuelPriority();
    //  PriorityQueue<elements> que2 = new PriorityQueue<elements>(4,strategy);
      List<elements> que = new ArrayList<elements>();
      
     que.add(new elements("a",5));
     elements.addElement(que.get(0));
    
     que.add(new elements("b",2));
     elements.addElement(que.get(1));
     
     que.add(new elements("c",1));
     elements.addElement(que.get(2));
      
     que.add(new elements("d",4)); 
     elements.addElement(que.get(3));
     
     System.out.println("In ele:- "+elements.printAllId());
     
  //   Collections.sort(que, strategy);
      
     
     elements.getElement("a").no=1;  //MODIFICATION OF ELEMENT DURING RUNTIME
    
      Collections.sort(que, strategy) ; //needed sorting every time when modifying..
      
     
      while(!que.isEmpty()){
           System.out.println();
        
          elements el = que.remove(0);
        
          elements.removeElement(el.id);
          
          System.out.println("POped out:- "+el.toString());
             System.out.println("In ele:- "+elements.printAllId());
             
      }
      
      
      
     // HashMap<elements> hm = new HashMap<elements>();
      
      
      
    
    }
    
    
}
