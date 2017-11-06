package com.algorithm.dynamicprogramming;
 
import java.util.Scanner;
 
public class CoinChangeProblem {
      public static void main(String[] args) {
            @SuppressWarnings("resource")
            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter Denomination array Size");
            int N=scanner.nextInt();
            int[] deno=new int[N];
            System.out.println("Please Enter Denomination Space seprated");
            for(int i=0;i<N;++i) {
                  deno[i]=scanner.nextInt();
            }
            System.out.println("Please Enter Amount you want to check");
            int amount=scanner.nextInt();
            CoinChangeProblem changeProblem=new CoinChangeProblem();
            System.out.println(changeProblem.coinChangeProblem(deno, amount));
           
      }    
      int max(int a,int b) {
            return a>b?a:b;
      }
      int coinChangeProblem(int[] deno,int amount){
            int[][] resultant=new int[deno.length+1][amount+1];
            for(int i=1;i<deno.length+1;++i) {
                  resultant[i][0]=1;
            }
            for(int i=1;i<deno.length+1;++i) {
                  for(int j=1;j<amount+1;++j) {
                        if(j>=deno[i-1]) {
                              resultant[i][j]=resultant[i-1][j]+resultant[i][j-deno[i-1]];
                        }
                        else {
                              resultant[i][j]=resultant[i-1][j];
                        }
                  }
            }
            return resultant[deno.length][amount];
      }
     
}
