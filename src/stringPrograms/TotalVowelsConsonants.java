package stringPrograms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TotalVowelsConsonants {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int Vowel=0, Consonant=0;
		str=str.toLowerCase();
		for(int i=0;i<str.length();i++)
		{
			
		if(str.charAt(i)=='a'||str.charAt(i)=='e'||str.charAt(i)=='i'||str.charAt(i)=='o'||str.charAt(i)=='u')
		{
			Vowel++;
		}
		else if(str.charAt(i)>'a' && str.charAt(i)<'z')
		{
			Consonant++;
		}
		}
		System.out.println("Number of Vowels: " +Vowel+ "Number of Consonants: " +Consonant);
	}

}
