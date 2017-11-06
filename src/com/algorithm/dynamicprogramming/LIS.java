package com.algorithm.dynamicprogramming;
 
import java.util.Scanner;
 
public class LIS {
 
      public static void main(String[] args) {
            @SuppressWarnings("resource")
            Scanner scanner=new Scanner(System.in);
            int N=scanner.nextInt();
            int array[]=new int[N];
            LIS lis=new LIS();
            for(int i=0;i<N;++i) {
                  array[i]=scanner.nextInt();
            }
           
            System.out.println(lis.longestIncreasingSubsequence(array, N));
           
      }
      int max(int a,int b) {
            return a>b?a:b;
      }
      int min(int a,int b) {
            return a<b?a:b;
      }
      int longestIncreasingSubsequence(int[] array,int N) {
            int[] lis=new int[N];
            for(int i=0;i<N;++i) {
                  lis[i]=1;
            }
            for(int i=1;i<N;++i) {
                  for(int j=0;j<i;++j) {
                        if(array[i]>array[j]) {
                              lis[i]=max(lis[j]+1,lis[i]);
                        }
                  }
            }
            int maxv=0;
            for(int i=0;i<N;++i) {
                  maxv=max(maxv,lis[i]);
            }
            return maxv;
      }
 
}
