
import java.util.Scanner;


public class LongestIncreasingSubseq {

 public static void main(String args[]){
     
     Scanner sc=new Scanner(System.in);
    int n = sc.nextInt();
    int arr[]=new int[n];
    for(int i=0;i<n;i++){
        arr[i] = sc.nextInt();
    }
     int max=0;
    int LIS[]=new int[n];
    
     for(int i=1; i<n;i++){
         for(int j=0; j<i; j++){
             if (arr[i] > arr[j]){
                 LIS[i] = max( 1+LIS[j]  ,  LIS[i]);
                 if (LIS[i] > max) max=LIS[i];
             }
         }
     }
     
     System.out.println(max+1);
     
 }
    
 public static int max(int x,int y){
     if (x>=y) return x;
     else return y;
 }
 
}
