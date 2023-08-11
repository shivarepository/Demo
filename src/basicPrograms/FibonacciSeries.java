package basicPrograms;

import java.util.Scanner;

public class FibonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num=10, fib1=0,fib2=1, fib3;
		System.out.print(+fib1 + "," +fib2);
		for(int i=2;i<num;i++)
		{
			fib3 = fib1 + fib2;
			System.out.print(","+fib3);
			fib1=fib2;
			fib2=fib3;
			
		}
	
	}

}
