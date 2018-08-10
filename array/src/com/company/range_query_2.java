package com.company;

import java.util.Scanner;

public class range_query_2 {


    public static boolean findIt(byte[] bin, int l ,int r){
//        String res="";

        int intVal=0;
        int exp = r-l;

        for(int i=l-1; i<r; i++, exp--){
            if (bin[i] == 1){
                intVal += Math.pow(2,exp) ;
            }
        }

//        System.out.println("Int is : " + intVal);

        if (intVal % 2 ==0){
            return true;
        } else {
            return false;
        }

//        return "";
    }

    public static void main(String args[]){

        long startTime = System.nanoTime();

        int N,Q;
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        Q = sc.nextInt();

        byte bin[]=new byte[N];

        for(int j=0;j<N; j++){
            bin[j] = sc.nextByte();
        }



        while(--Q >= 0) {
            byte code =  sc.nextByte();
//            System.out.println("in "+Q);
            if (code == 0){
                int l=sc.nextInt();
                int r=sc.nextInt();


                if (bin[r-1] == 0){
                    System.out.println("EVEN");
                } else {
                    System.out.println("ODD");
                }

            } else {
                int flipInd = sc.nextInt();
//                System.out.println("bef: "+ bin[flipInd-1]) ;
//                bin[flipInd-1] = (byte) ~(int)bin[flipInd-1] ;
                bin[flipInd-1] = (byte) ((bin[flipInd-1] + 1) % 2);

//                System.out.println("aft: "+ bin[flipInd-1]) ;
            }
        }

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);


    }

}
