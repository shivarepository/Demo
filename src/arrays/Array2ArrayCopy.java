package arrays;

import java.util.Scanner;

public class Array2ArrayCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = new int[5];
		int arr2[] = new int[5];
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<arr1.length;i++)
		{
			arr1[i] = sc.nextInt();
		}
		for(int j=0;j<arr1.length;j++)
		{
			System.out.println(arr1[j]);
		}
		arr2= arr1.clone();
		System.out.println(arr2.length);
		for(int k=arr2.length-1;k>=0;k--)
		{
			System.out.println(arr2[k]);
		}
	}
}
