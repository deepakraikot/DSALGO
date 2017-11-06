package com.algorithm.dynamicprogramming;

import java.util.Scanner;


public class MaximumSumIncreasingSequence {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;++i){
			arr[i]=scanner.nextInt();
		}
		MaximumSumIncreasingSequence increasingSequence=new MaximumSumIncreasingSequence();
		System.out.println(increasingSequence.maximumSumIncreasingSequence(arr, n));
		scanner.close();
	}
	int maximumSumIncreasingSequence(int[] arr,int n){
		int[] sum=new int[n];
		sum[0]=arr[0];
		for(int i=0;i<n;++i)
			sum[i]=arr[i];
		int max=sum[0];
		for(int i=1;i<n;++i){
			for(int j=0;j<i;++j){
				if(arr[i]>arr[j] && sum[i]<sum[j]+arr[i]){
					sum[i]=sum[j]+arr[i];
					if(max<sum[i]){
						max=sum[i];
					}
				}
			}
		}
		return max;
	}

}
