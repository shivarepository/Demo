package basicPrograms;

import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = 7,flag=0, num1=0;
	    num1 = num/2;
		for(int i=2;i<=num1;i++)
		{
			if((num%i)==0)
			{
				System.out.println("Not an Prime");
				flag=1;
				break;
				
			}
		}
		if(flag==0)
		{
			System.out.println("Prime");
		}
	}

}
