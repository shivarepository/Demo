package stringPrograms;

import java.util.Scanner;

public class NumberOfWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		String str1 = s.nextLine();
		String str=str1.toLowerCase();
		String arr[] = str.split(" ");
		int count=1;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i].equals(arr[j]))
				{
					count++;
					arr[j] ="0";
				}
			}
			
			if(arr[i]!="0" && count>1)
			{
				System.out.println("The word is: " +arr[i] +"Total number of words in sentence: " +count);
			}
		}
	}
}
