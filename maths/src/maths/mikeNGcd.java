
package maths;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.*;

public class mikeNGcd {
    
    
       static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
        
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
        
       
       private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
        
        
       private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
        
     }
    
    
    
    
    public static int gcd(int x , int y){
        int big=0,small=0;
        
        if (y>x) { big = y ; small = x;
        }
        else{
              big = x ; small = y; 
        }
              
        
        
        if (big%small==0) return small;
            return gcd(small , big%small);
          
    }
    
    public static boolean iseven(int x){
        
        return (x%2==0);
    }
    
    public static void main(String args[]) throws IOException{
        
      //  Scanner sc=new Scanner(System.in);
         Reader sc=new Reader();
     
        int n = sc.nextInt();
        int num[] = new int[n];
        int mark[] = new int[n];
        
        for(int i=0;i<n;i++){
            num[i] = sc.nextInt();
        }
        
   
        for(int curr=0 ; curr<n ; curr++){
             for(int i=1 ; curr+i<n || curr-i>=0 ; i++  ){
                
                if (curr-i>=0){
                   
                   if ( iseven(num[curr]) && iseven(num[curr-i])  ){
                       mark[curr] = curr-i;
                       break;
                   }
                   else if ( gcd( num[curr] , num[curr-i] ) > 1 ) {
                       mark[curr] = curr-i;
                       break;
                   }
                       
               }
               
               if (curr+i<n){
                   
                   if ( iseven(num[curr]) && iseven(num[curr+i])  ){
                       mark[curr] = curr+i;
                       break;
                   }
                   else if ( gcd( num[curr] , num[curr+i] ) > 1 ) {
                       mark[curr] = curr+i;
                       break;
                   }
                       
               }
               
               mark[curr] = -2; 
               
               
               
               
            }
        }
        
        
        
        for(int i=0;i<n;i++){
            
            System.out.print((mark[i]+1)+" ");
        }
        
        
    }
}
