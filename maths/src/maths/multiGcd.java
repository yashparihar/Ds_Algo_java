package maths;


import java.util.*;


public class multiGcd {
    public static int ele[];
    
    public static void main(String args[]){
        
        Scanner sc=new Scanner(System.in);
        int n =sc.nextInt();
        ele = new int[n];
        
        for(int i=0;i<n;i++){
         ele[i] = sc.nextInt();
        }
        
        int ans = divCon(0 , n-1);
   
        System.out.println(ans);
    }
    
    public static int divCon(int s , int l){
       // return gcd(ele[0] , ele[1] );
       
       if (l-s==1){
           if (ele[l]>=ele[s]) return gcd(ele[l] , ele[s]);
           else                return gcd(ele[s] , ele[l]);    
       }
       else if (l-s==0)
           return ele[s];
       
       int mid = (s+l)/2;
       
       int ans1 = divCon(s , mid);
       int ans2 = divCon(mid+1 , l);
       
       return gcd(ans1 , ans2);
       
       
    }
    
    public static int gcd(int x , int y){
        if (x%y==0) return y;
        else
            return gcd(y , x%y);
        
    }


    
}
