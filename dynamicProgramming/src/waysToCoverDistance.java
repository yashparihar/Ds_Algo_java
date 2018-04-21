
import java.util.*;

public class waysToCoverDistance {

  public static void main(String a[]){
      
      Scanner sc=new Scanner(System.in);
      int distance = sc.nextInt();
      int steps = sc.nextInt();
      
      int store[]=new int[distance];    
      int min1 = MemoizationMethod(store ,distance , steps);
      
         int store2[]=new int[distance+1];
      int min2= TabulationMethod(store2 , distance , steps);
      
   
      System.out.println(min1 +" " +min2);
  }
  
  
  public static int TabulationMethod(int store[] , int d, int s){
      
      store[0] = 1 ;
      
      int sum = 0; 
      
      for(int i=1;i<=s;i++){     
          store[i] = ( sum+= store[i-1] );
          
      }
      
      for(int i=s+1 ; i<=d; i++){
          for(int stp=1;stp<=s;stp++){
              store[i]+= store[i-stp];
          }
      }
      
      return store[d];
      
  }
  
  public static int MemoizationMethod(int store[] ,int d , int s){
      
      if (d==0) return 1;
      
      
      int tot =0;
      
      for(int i=1; i<=s && d-i>=0 ; i++) {
          if (store[d-i]!=0)  tot+=store[d-i];
          else  tot+= ( store[d-i] = MemoizationMethod(store , d-i , s ) );
       }
      
      return tot;
  }
  
  
    
}
