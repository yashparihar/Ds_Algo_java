package maths;

import java.util.*;



public class unionIntersectionSet {

    public static void main(String args[]){
          Scanner sc=new Scanner(System.in);
          Set s1 = new HashSet();
          Set s2 = new TreeSet();
          
          int n = sc.nextInt();
          
         for(int i=0;i<n;i++)
               s1.add(sc.nextInt());
           for(int i=0;i<n;i++)
                s2.add(sc.nextInt());
      
           Set union = new TreeSet(s1);
           union.addAll(s2);
           
           Set intersect = new TreeSet(s1);
           intersect.retainAll(s2);
           
           
           Iterator it = intersect.iterator();
    
           while(it.hasNext()){
               System.out.println((int)it.next());
           }
    }
    
}
