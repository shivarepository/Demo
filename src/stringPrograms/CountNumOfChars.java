package stringPrograms;

import java.util.Scanner;

public class CountNumOfChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count=0, PunctCount=0;
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] arrChar = str.toCharArray();
		for(int i=0;i<arrChar.length;i++)
		{
			System.out.println(arrChar[i]);
			
			if(arrChar[i]!=' ') {
			count++;}
			
			if(arrChar[i]=='!' || arrChar[i]=='.'||arrChar[i]==',')
			{
				PunctCount++;
			}
		}
		System.out.println("Total no of Cha's in String: " +count+ " Total no of punctuations in String: " +PunctCount);
		sc.close();
	}

}
