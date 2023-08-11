package collectionPrograms;

import java.util.ArrayList;
import java.util.Iterator;

public class SampleProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> arrlist= new ArrayList<Integer>();
		arrlist.add(10);
		arrlist.add(20);
		arrlist.add(30);
		arrlist.add(40);
		arrlist.add(50);
		
		Iterator itr = arrlist.iterator();
		System.out.println("Number of elements in list: ");
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		System.out.println("---------------");
		for(Integer intarr:arrlist)
		{
			System.out.println(intarr);
		}
	}
}
