package collectionPrograms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SortingList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		ArrayList<String> arstr= new ArrayList<String>();
		arstr.add("Mango");
		arstr.add("Apple");
		arstr.add("Orrange");
		arstr.add("Banana");
		arstr.add("Pomogranite");
		arstr.add(sc.nextLine());
		for(String str:arstr)
		{
			System.out.println("Elements of the list: " +str);
		}

		Collections.sort(arstr);
		
		System.out.println("---After sorting the elements---");
		for(String str1:arstr)
		{
			System.out.println("Elements of the list: " +str1);
		}
	}

}
