/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yash
 */
import java.util.*;

public class PartitionSubsetSum {
 
    public static void main(String argsp[]){
        
       int arr[]={22 , 14 , 11 ,  5}; 
        int min = 0;
       int sum=0;
        for(int i=0;i<arr.length ; i++)
            sum+=arr[i];
        
       min = PSS(arr , arr.length-1 , 0 , sum);
        
    
        
        System.out.println(min);
    }
    
    
    public static int PSS(int arr[] ,int n, int calculated , int totalSum ){
    
        if (n==0)
            return Math.abs((totalSum - calculated) - calculated) ;
        
        return minimum( PSS(arr , n-1 , calculated , totalSum ) , 
                        PSS(arr , n-1 , calculated+arr[n] , totalSum ) );
        
        
    }
    
    
    public static int minimum(int x, int y){
        if (x <= y) return x;
        else    return y;
    }
}
