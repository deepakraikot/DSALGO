package com.algorithm.dynamicprogramming;
 
import java.util.Scanner;
 
public class MinimumEdits {
 
      public static void main(String[] args) {
            @SuppressWarnings("resource")
            Scanner scanner=new Scanner(System.in);
            System.out.println("Please Enter First String");
            String s1=scanner.nextLine();
            System.out.println("Please Enter Second String");
            String s2=scanner.nextLine();
            System.out.println("Wait your result is ready...");
            MinimumEdits edits=new MinimumEdits();
            System.out.println(edits.minimumedits(s1, s2));
      }
      int min(int a,int b) {
            return a<b?a:b;
      }
      int minimumedits(String s1,String s2) {
            int[][] editMatrix=new int[s1.length()+1][s2.length()+1];
            for(int i=1;i<s1.length()+1;++i) {
                  editMatrix[i][0]=i;
            }
            for(int i=1;i<s2.length()+1;++i) {
                  editMatrix[0][i]=i;
            }
            for(int i=1;i<s1.length()+1;++i) {
                  for(int j=1;j<s2.length()+1;++j) {
                        if(s1.charAt(i-1)==s2.charAt(j-1)) {
                              editMatrix[i][j]=editMatrix[i-1][j-1];
                        }
                        else {
                              editMatrix[i][j]=min(editMatrix[i][j-1],min(editMatrix[i-1][j], editMatrix[i-1][j-1]))+1;
                        }
                  }
            }
            return editMatrix[s1.length()][s2.length()];
      }
 
}
