package com.algorithm.dynamicprogramming;

import java.util.Scanner;

public class MaximumChainPair {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Please Enter Number of pair you want to Enter");
		int n=scanner.nextInt();
		int arr[][]=new int[n][2];
		for(int i=0;i<n;++i){
			System.out.println("Please Enter "+i+" Pair");
			for(int j=0;j<2;++j){
				arr[i][j]=scanner.nextInt();
			}
		}
		MaximumChainPair chainPair=new MaximumChainPair();
		System.out.println("Please wait your result is generating...");
		System.out.println(chainPair.maximumChainPair(arr, n));
		scanner.close();
	}
	int maximumChainPair(int[][] arr,int n){
		int[] lis=new int[n];
		for(int i=0;i<n;++i){
			lis[i]=1;
		}
		int max=lis[0];
		for(int i=1;i<n;++i){
			for(int j=0;j<i;++j){
				if(arr[i][0]>arr[j][1] && lis[i]<lis[j]+1){
					lis[i]=lis[j]+1;
					if(max<lis[i])
						max=lis[i];
				}
			}
		}
		return max;
	}
	

}
