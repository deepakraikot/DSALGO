package com.algorithm.dynamicprogramming;
 
import java.util.Scanner;
 
public class MinimumJumpToReachAtEnd {
      public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);
            System.out.println("Please Enter number of element you want to Enter");
            int n=scanner.nextInt();
            int arr[]=new int[n];
            System.out.println("Please Enter Space Seprated Elements");
            for(int i=0;i<n;++i) {
                  arr[i]=scanner.nextInt();
            }
            MinimumJumpToReachAtEnd atEnd=new MinimumJumpToReachAtEnd();
            System.out.println("Result:-"+atEnd.minJumps(arr, n));
            scanner.close();
           
      }
      int minJumps(int arr[], int n)
      {
      int[] jumps=new int[n];
      jumps[n-1]=0;
      for(int i=n-2;i>=0;--i) {
            if(arr[i]==0)
                  jumps[i]=0;
            else if(arr[i]>=n-i-1)
                  jumps[i]=1;
            else {
                  int min=Integer.MAX_VALUE;
                  for(int j=i+1;j<n & j<=arr[i]+i;++j) {
                        if(min>jumps[j])
                              min=jumps[j];
                  }
                  jumps[i]=min!=Integer.MAX_VALUE?min+1:min;
            }
           
      }
      return jumps[0];
      }
}
