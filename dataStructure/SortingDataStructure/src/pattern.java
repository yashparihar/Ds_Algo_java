
import java.util.*;


public class pattern {


public static void main(String args[]){
    
    Scanner sc=new Scanner(System.in);
    
    int n=sc.nextInt();
    
    
    
    for(int i=1;i<=n;i++){
        
        funcPrint(1,i , false); 
        System.out.println();
    }
}

    private static void funcPrint(int i , int x , boolean flg) {
  
        if (i>x || i<=0)
            return;
 
        else if (i==x) 
            flg=true;
          
        
        
        if (flg) {
           System.out.print(i);
          funcPrint(--i,x,flg);
        }
        else{
            System.out.print(i);
          funcPrint(++i,x,flg);
        }
        
    }
    
}
