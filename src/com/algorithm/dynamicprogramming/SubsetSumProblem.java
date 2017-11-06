package com.algorithm.dynamicprogramming;

import java.util.Scanner;

public class SubsetSumProblem {
	public static void main(String[] args) {
		System.out.println("Enter Subset Array Length:");
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		System.out.println("Enter value one by one");
		int[] subset=new int[n];
		for(int i=0;i<n;++i) {
			subset[i]=scanner.nextInt();
		}
		SubsetSumProblem problem=new SubsetSumProblem();
		System.out.println("Please Enter Sum you want to make");
		int sum=scanner.nextInt();
		boolean[][] subsetMatrix=problem.subsetSubProblem(subset, sum);
		problem.printSubArray(subsetMatrix, n+1, sum, subset);
		scanner.close();
	}
	void printSubArray(boolean[][] subsetMatrix,int n,int m,int[] subset) {
		boolean[] result=subsetMatrix[m];
		for(int i=0;i<n;++i) {
			if(result[i]==true) {
				System.out.print(subset[i-1]+" ");
				int nxt=m-subset[i-1];
				if(nxt!=0) {
					printSubArray(subsetMatrix, n, nxt, subset);
				}
				else {
					return;
				}
				break;
			}
		}
	}
	boolean[][] subsetSubProblem(int[] subset,int sum){
		boolean[][] subsetmatrix=new boolean[sum+1][subset.length+1];
		for(int i=0;i<=subset.length;++i) {
			subsetmatrix[0][i]=true;
		}
		for(int i=1;i<=sum;++i) {
			subsetmatrix[i][0]=false;
		}
		for(int i=1;i<=sum;++i) {
			for(int j=1;j<=subset.length;++j) {
				subsetmatrix[i][j]=subsetmatrix[i][j-1];
				if(i>=subset[j-1]) {
					subsetmatrix[i][j]=subsetmatrix[i][j] || subsetmatrix[i-subset[j-1]][j-1];
				}
			}
		}

		return subsetmatrix;
	}
}
