package arrays;

import java.util.Scanner;

public class NumberDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr1[] = {10,20,30,20,10,40,50,10};
		int temp[] = new int[arr1.length];
		int visited = -1;
		
		for(int i=0;i<arr1.length;i++)
		{
			int count=1;
			for(int j=i+1;j<arr1.length;j++)
			{
				if(arr1[i]==arr1[j])
				{
					count++;
					temp[j] = visited;
				}
			}
			if(temp[i]!=visited)
			{
				temp[i]=count;
			}
		}
			System.out.println("Element | Frequency");
			for(int k=0;k<temp.length;k++)
			{
				
				if(temp[k]!=visited)
				{
					System.out.println(" " +arr1[k]+ " | " +temp[k]);
				}
			}
		}
	}
