
import java.util.Scanner;


public class subsetSum {

static Scanner sc=new Scanner(System.in);
    
 
    
public static void main(String args[]){    
 int n=0;
 int sum;
 int setEle[];

System.out.println("Enter size:"); 
n = sc.nextInt();

 setEle=new int[n+1];  

System.out.println("Enter set Elements: ");
getElement(setEle, n+1);

System.out.println("Enter sum: ");
sum = sc.nextInt();

int ele[][] = calcSubsetSum( n , sum , setEle);

display(ele , n , sum);

}


 //FETCHING ELEMENT FROM USER...............................
   public static void getElement(int ele[], int n){
     int ne=n-1;
     
     ele[0] = 0;
     while(ne>0){
         ele[n-ne] = sc.nextInt();
        ne-=1;
     }
 }  


  //CALCULATING ALL THE RELATED SET 
    private static int[][] calcSubsetSum( int n, int sum, int[] setEle) {
      int[][] m= new int[n+1][sum+1];
      
      for(int i=0;i<=n;i++){
          m[i][0] = 1;
      }
      for(int i=1;i<=sum;i++){
          m[0][i] = 0;
      }
      
      for(int i=1;i<=n ; i++){
          for(int j=1;j<=sum; j++){
              if (j<setEle[i])
                  m[i][j] = m[i-1][j];
              else
                  m[i][j] = m[i-1][j] | m[i-1][j-setEle[i]] ;
          }
      }
      
      return m;
      
    }

    
    //DISPLAYING ALL THE RESULT
    private static void display(int[][] ele , int n , int sum) {
       
        for(int i=0; i<=n ; i++){
            System.out.println();
            for(int j=0;j<=sum ; j++){
               System.out.print(" "+ele[i][j]);
            }
        }
       
    }
}
