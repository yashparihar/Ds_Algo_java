package com.company;

import java.io.*;
import java.util.Scanner;

public class memorise_me {

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

    static class Print {
        private final BufferedWriter bw;

        public Print() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }


    public static void main(String args[]) throws IOException {

//      long startTime = System.nanoTime();

        int N, Q;
        Reader sc=new Reader();

        OutputStream out = new BufferedOutputStream ( System.out );

        N = sc.nextInt();
        int occurence[] = new int[1001];

        short[] nele = new short[N];
        for (int j = 0; j < N; j++) {
            nele[j] = sc.nextShort();
            occurence[ nele[j] ]+= 1;
        }

        Q = sc.nextInt();
        for (int j = 0; j < Q; j++) {
            short ele = sc.nextShort();

            if (occurence[ele] == 0)
                  out.write(("NOT PRESENT\n").getBytes());
            else
                  out.write((occurence[ele] + "\n").getBytes());

            out.flush();
        }

    }

}
