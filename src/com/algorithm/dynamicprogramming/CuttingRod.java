package com.algorithm.dynamicprogramming;
 
import java.util.Scanner;
 
public class CuttingRod {
 
      public static void main(String[] args) {
            System.out.println("Enter Maximum size of rod length");
            Scanner scanner=new Scanner(System.in);
            int n=scanner.nextInt();
            int[] price=new int[n];
            for(int i=0;i<n;++i) {
                  price[i]=scanner.nextInt();
            }
            CuttingRod cuttingRod=new CuttingRod();
            int[] result=cuttingRod.cuttingRod(price, n);
            System.out.println("Rod cut in following denomination we get Maximum amount");
            System.out.println(result[0]+" "+result[1]);
            System.out.println("Maximum amount is given below");
            System.out.println(result[2]);
            scanner.close();
      }
      int max(int a,int b) {
            return a>b?a:b;
      }
      int[] cuttingRod(int[] price,int rodLength) {
            int val[]=new int[3];
            val[0]=0;
            val[1]=rodLength;
            val[2]=price[rodLength-1];
            int temp=0;
            for(int i=0;i<rodLength/2;++i) {
                  temp=price[i]+price[rodLength-i-2];
                  if(temp>val[2]) {
                        val[0]=i+1;
                        val[1]=rodLength-2;
                        val[2]=temp;
                  }
            }
            return val;
           
           
      }
}
