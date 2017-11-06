package com.algorithm.dynamicprogramming;
 
import java.util.Scanner;
 
public class AssemblyLine {
 
      public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);
            int Num=scanner.nextInt();
            System.out.println("Please enter Value");
            int t[][]=new int[2][Num];
            int a[][]=new int[2][Num];
            for(int i=0;i<2;++i) {
                  System.out.println("Please Enter "+Num+" Space Seprated Value");
                  for(int j=0;j<Num;++j) {
                        a[i][j]=scanner.nextInt();
                  }
            }
            for(int i=0;i<2;++i) {
                  System.out.println("Please Enter "+Num+" Space Seprated Value");
                  for(int j=0;j<Num;++j) {
                        t[i][j]=scanner.nextInt();
                  }
            }
            System.out.println("Enter Starting Cost");
            int e[]=new int[2];
            for(int i=0;i<2;++i) {
                  e[i]=scanner.nextInt();
            }
            System.out.println("Enter Ending Cost");
            int c[]=new int[2];
            for(int i=0;i<2;++i) {
                  c[i]=scanner.nextInt();
            }
            AssemblyLine assemblyLine=new AssemblyLine();
            System.out.println("Result:-"+assemblyLine.assemblyLine(t, a, e, c, Num));
            scanner.close();
           
      }
      int min(int a,int b) {
            return a<b?a:b;
      }
      int assemblyLine(int[][] t,int[][] a,int[] e,int[] c,int Num) {
            int T1[]=new int[Num];
            int T2[]=new int[Num];
            T1[0]=e[0]+a[0][0];
            T2[0]=e[1]+a[1][0];
            for(int i=1;i<Num;++i) {
                  T1[i]=min(T1[i-1]+a[0][i],T2[i-1]+t[1][i]+a[0][i]);
                  T2[i]=min(T2[i-1]+a[1][i],T1[i-1]+t[0][i]+a[1][i]);
            }
            return min(T1[Num-1]+c[0],T2[Num-1]+c[1]);
      }
}
