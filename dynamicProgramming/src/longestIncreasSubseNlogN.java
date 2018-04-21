
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yash
 */
public class longestIncreasSubseNlogN {
    
    public static void main(String arrgs[]){
           Scanner sc=new Scanner(System.in);
    int n = sc.nextInt();
    int arr[]=new int[n];
    int pyr[]=new int[n];
    for(int i=0;i<n;i++){
        arr[i] = sc.nextInt();
    }
  
    int len=0;
    pyr[0] = arr[0];
    
    for(int i=1;i<n;i++){
       
        for(int j=0;j<=len;){
            if (arr[i]<pyr[j]) {
                pyr[j] = arr[i];
                break;
            }
            else{
                if (j<len) j++;
                else {
                       len++;
                       pyr[len] = arr[i];
                       break;
                }
                
            }
        }
    }  
    
    
    System.out.println(len+1);
  }
    
}
