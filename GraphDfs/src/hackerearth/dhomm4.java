package hackerearth;

import java.util.*;

public class dhomm4 {
    
    public static int N ;
    public static int lockVal;
     public static int keys[];
    
    public static class node{
        public int val;
        public boolean traversedKey[];
       
        node(){
            
        }
        node(int val){
            traversedKey=new boolean[N];
            this.val = val;
        }
          node(int val,boolean tk[] , int tIndex){
            traversedKey=tk;
           traversedKey[tIndex] = true;
            this.val = val;
        }
        
    }
    
    public static void main(String args[]){
        
        Scanner sc=new Scanner(System.in);
        int mykey = sc.nextInt();
         lockVal = sc.nextInt();
         N=sc.nextInt();
         keys=new int[N];
        
        
        
        for(int i=0;i<N;i++){
            keys[i] = sc.nextInt();
        }
        
        Queue<node> q = new LinkedList<node>();
        
        q.add( new node( mykey) );
        
       
        
        int ans = minKeys(0, q );
        
        System.out.println(ans);
        
        
        
    }
    
    
    public static int minKeys(int c ,Queue q ){
  
        if (q.isEmpty()) {
             return -1;
        }
        
        boolean flg=false;
        Queue q2 = new LinkedList();
        node ele;//=null;
        while ( (ele=(node)q.poll())!=null ){
            
        //     System.out.println(ele.val);
            if (ele.val==lockVal) {
               
                flg=true; break;
            }
            
            for(int i=0;i<keys.length  ; i++){
             //   System.out.println("n:"+ keys.length);
                if (ele.traversedKey[i]) continue;
                
                int evalVal = (ele.val * keys[i])%100000;
            //    System.out.println(" eval: "+evalVal);
                if (lockVal%evalVal!=0) continue;
          //      else if (evalVal == lockVal) System.out.println("got:");
                
                q2.add((new node(evalVal ,ele.traversedKey, i)));
                
                    
            }
            
        }
        
        if (flg) return c;
        else return minKeys( ++c ,q2 );
        
    }
    
    
}
