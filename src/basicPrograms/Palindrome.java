package basicPrograms;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rev=0, rem,temp;
//		System.out.println("Enter the number to find an palindrome");
//		Scanner s = new Scanner(System.in);
		int num = 1245;
		temp=1225;
		while(num>0)
		{
			rem=num%10;
			rev=(rev*10)+rem;
			num=num/10;
		
		}
		if(temp == rev)
		{
			System.out.println("Its a palindrome " +rev);
		}
	}

}
