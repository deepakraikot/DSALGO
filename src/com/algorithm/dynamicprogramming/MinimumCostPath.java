package com.algorithm.dynamicprogramming;

import java.util.Scanner;

public class MinimumCostPath {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		int N=scanner.nextInt();
		int M=scanner.nextInt();
		int cost[][]=new int[N][M];
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				cost[i][j]=scanner.nextInt();
			}
		}
		MinimumCostPath costPath=new MinimumCostPath();
		System.out.println(costPath.minimumcostPath(cost, N, M));

	}
	int min(int a,int b) {
		return a<b?a:b;
	}
	int max(int a,int b) {
		return a>b?a:b;
	}
	int minimumcostPath(int[][] cost,int N,int M){
		int path[][]=new int[N][M];
		path[0][0]=cost[0][0];
		for(int j=1;j<M;++j)
			path[0][j]=path[0][j-1]+cost[0][j];
		for(int i=1;i<N;++i) {
			for(int j=0;j<M;++j) {
				if(j>0 && i>0) {
					path[i][j]=min(path[i-1][j-1],min(path[i][j-1],path[i-1][j]))+cost[i][j];
				}
				else if(i>0) {
					path[i][j]=path[i-1][j]+cost[i][j];
				}
			}
		}
		return path[N-1][M-1]; 
	}

}
