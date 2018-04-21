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

public class longestCommonSubsequence {
    
    
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        
        String str1 = sc.next();
        String str2 = sc.next();
        int s1 = str1.length();   int s2 = str2.length();
        int tab[][]=new int[s1][s2];
        char dir[][] = new char[s1][s2];
        
        LCS(str1, str2 , tab, dir);
        System.out.println(tab[s1-1][s2-1]);
        System.out.println("Common seq="+retriveString(tab , dir , str1));
       
        
    }
 
    
    
    
    public static void LCS(String s1 , String s2 , int tab[][] , char dir[][] ){
        
        for(int i=0;i<s1.length() ; i++){
            
            for(int j=0;j<s2.length() ; j++){
                
                if (s1.charAt(i)==s2.charAt(j)){
                    if (i==0 || j==0)
                        tab[i][j] = 1;
                    else
                        tab[i][j] = 1 + tab[i-1][j-1];
                    
                    dir[i][j] = 'd';
                    
                }
                else{
                    
                    if (i==0 && j!=0) tab[i][j] = tab[i][j-1];
                    else if (j==0 && i!=0) tab[i][j] = tab[i-1][j];
                    else if (i!=0 && j!=0) { 
                        if (tab[i][j-1] >= tab[i-1][j]) {
                            tab[i][j] = tab[i][j-1];
                            dir[i][j] = 'l';
                        }
                        else{
                            tab[i][j] = tab[i-1][j];
                            dir[i][j] = 'u';
                        }
                    
                    }
                }
            }
        }
        
        
    }
    
    public static String retriveString(int tab[][] , char dir[][] , String str){
        
        String com="";
        
        int i = tab.length-1;
        int j = tab[0].length-1;
        
        
        while(i>=0 && j>=0){
 // System.out.println("i="+i+" j="+j);          
            if (dir[i][j] == 'd'){
                com=str.charAt(i) + com;
                i--; j--;
            }
            else if (dir[i][j] == 'u') 
               i--;
            else if (dir[i][j] == 'l')
                j--;
            else if (tab[i][j] == 0)
                break;
            else if (i==0) j=j-1;
            else if (j==0) i=i-1;
        }
        
        return com;
    }
    
    
    public static int max(int ele1 , int ele2){
        if (ele1>ele2) return ele1;
        else return ele2;
    }
}
