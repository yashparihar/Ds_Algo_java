package com.company;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;

/*
 2
6 3
8 2 3 11 11 10
5 12
12 20 39 45 89
 */

public class maximize_earning {


    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public short nextShort() throws IOException {
            short ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = (short) (ret * 10 + c - '0');
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return (short) -ret;
            return ret;
        }


        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }


        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }

    }

    public static void main(String args[]) throws IOException {

        Reader sc = new Reader();
        OutputStream out = new BufferedOutputStream(System.out);

        short S = sc.nextShort();

        while(S-- > 0){
            int N = sc.nextInt();
            int earn = sc.nextInt();

            double max = 0.5;
            int views=0;
            for(int bno=0; bno<N; bno++){
                int bh = sc.nextInt();

                if (bh > max){
                    views++;
                    max = bh;
                }

            }
//            System.out.println("iin"+ views );
            int totearn = views * earn;
//            System.out.println(totearn);

            out.write(((totearn)+"\n").getBytes() );
            out.flush();
        }

    }
}
