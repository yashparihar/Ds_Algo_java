/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimalway;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
*/
import java.io.BufferedReader;
import java.io.*;
import java.io.InputStreamReader;
import java.math.BigInteger;

//import for Scanner and other utility classes
import java.util.*;


class Optimalway {
    
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
    
    static class Print
{
    private final BufferedWriter bw;
    public Print()
    {
        this.bw=new BufferedWriter(new OutputStreamWriter(System.out));
    }
    public void print(Object object)throws IOException
    {
        bw.append(""+object);
    }
    public void println(Object object)throws IOException
    {
        print(object);
        bw.append("\n");
    }
    public void close()throws IOException
    {
        bw.close();
    }
}
     
     
     
    public static void main(String args[] ) throws Exception {
      
        //Scanner
    //  Scanner s = new Scanner(System.in);
       // Reader sc=new Reader();
        Print p = new Print();
        BigInteger b;//=new BigInteger("");
     //   s.n
        Scanner sc=new Scanner(System.in);
        String d =sc.nextLine();
         int[] darr = new int[d.length()];
        StringBuilder encstr = new StringBuilder("");
        StringBuilder str = new StringBuilder("");
        
        for(int i=0;i<d.length();i++){
            darr[i] = 12 ^ d.charAt(i);
           System.out.println(darr[i]);
             encstr.append((char)darr[i]);
        }
        
        System.out.println("msg="+encstr);
        
         for(int i=0;i<encstr.length();i++){
            darr[i] = 12 ^ encstr.charAt(i);
           System.out.println(darr[i]);
             str.append((char)darr[i]);
        }
        
           System.out.println("got msg="+str);
        
        
        
        
        
        int N = sc.nextInt();
        //HashMap noprime = new HashMap();
         int noprime[]= new int[1000000];
      
    }
    
    
    
    
    public static boolean isprime(int x){
        if (x<=1) return false;
        
        boolean flg=true;
        for(int i=2;i<=Math.sqrt(x); i++){
            if (x%i==0){
                flg=false; break;
            }
            
        }
        return flg;
    }
}

