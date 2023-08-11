package stringPrograms;

import java.util.Scanner;

public class DuplicateChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count=0;
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] arr= str.toCharArray();
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]==arr[j] && arr[i]!=' ')
				{
					count++;
					arr[j]='0';
				}
			}
		if(count>1 && arr[i]!='0')
		{
			System.out.println(arr[i]);
			System.out.println("Count: " +count);
		}
		}
	}
}
