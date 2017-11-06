package com.algorithm.dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSizeSubMatrrix {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		int N=scanner.nextInt();
		int M=scanner.nextInt();
		int matrix[][]=new int[N][M];
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				matrix[i][j]=scanner.nextInt();
			}
		}
		MaximumSizeSubMatrrix matrrix=new MaximumSizeSubMatrrix();
		System.out.println(Arrays.deepToString(matrrix.findMaximum(matrix, N, M)));
	}
	int min(int a,int b) {
		return a<b?a:b;
	}
	int[][] findMaximum(int[][] matrix,int N,int M){
		int S[][]=new int[N][M];
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				if(matrix[i][j]==1) {
					if(j>0 && i>0)
						S[i][j]=min(S[i][j-1],min(S[i-1][j],S[i-1][j-1]))+1;
					else if(j>0)
						S[i][j]=min(S[i][j], S[i][j-1])+1;   
					else {
						S[i][j]=matrix[i][j];
					}
				}
				else {
					S[i][j]=0;
				}

			}
		}

		return S;

	}
}
